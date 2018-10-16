package socket.nonblock.nonblocking;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;

public class nonBlockServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel server = ServerSocketChannel.open();

        server.configureBlocking(false); // ser non-blocking
        server.bind(new InetSocketAddress(6666));

        // get a selector
        Selector selector = Selector.open();
        // register the channel to the selector,
        server.register(selector, SelectionKey.OP_ACCEPT);

        while (selector.select() > 0) {
            // get all  register selectedKeys
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                if (selectionKey.isAcceptable()) {
                    SocketChannel client = server.accept();

                    client.configureBlocking(false);
                    client.register(selector, SelectionKey.OP_READ);


                } else if (selectionKey.isReadable()) { // 读事件就绪

                    // 9. 获取当前选择器读就绪状态的通道
                    SocketChannel client = (SocketChannel) selectionKey.channel();

                    // 9.1读取数据
                    ByteBuffer buffer = ByteBuffer.allocate(1024);

                    // 9.2得到文件通道，将客户端传递过来的图片写到本地项目下(写模式、没有则创建)
                    FileChannel outChannel = FileChannel.open(Paths.get("2.png"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);

                    while (client.read(buffer) > 0) {
                        // 在读之前都要切换成读模式
                        buffer.flip();

                        outChannel.write(buffer);

                        // 读完切换成写模式，能让管道继续读取文件的数据
                        buffer.clear();
                        ByteBuffer writebuffer = ByteBuffer.allocate(1024);
                        writebuffer.put("the file is received ".getBytes());
                        writebuffer.flip();
                        client.write(writebuffer);
                    }
                }
                // 10. 取消选择键(已经处理过的事件，就应该取消掉了)
                iterator.remove();

            }
        }
    }
}
