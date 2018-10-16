package socket.nonblock.blocking;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class BlockClient {
    public static void main(String[] args) throws IOException {
        // connect to 6666 port
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 6666));

        // get filechannel
        FileChannel filechannel = FileChannel.open(Paths.get("F:\\mapTarget.txt"), StandardOpenOption.READ);


        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // send the file
        while (filechannel.read(buffer) != -1) {
            buffer.flip();

            socketChannel.write(buffer);

            buffer.clear();

        }
        // let server know the data is sent
        socketChannel.shutdownOutput();

        // wait the response from the server
        int len ;
        while ((len = socketChannel.read(buffer)) != -1) {
            buffer.flip();
            System.out.println(new String(buffer.array(), 0, len));
        }
        filechannel.close();
        socketChannel.close();
    }
}
