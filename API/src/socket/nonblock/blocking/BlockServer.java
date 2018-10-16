package socket.nonblock.blocking;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class BlockServer {
    public static void main(String[] args) throws IOException {

        ServerSocketChannel server = ServerSocketChannel.open();
        FileChannel outChannel = FileChannel.open(Paths.get("1.txt"), StandardOpenOption.WRITE,StandardOpenOption.CREATE);
        // bing the 6666 port
        server.bind(new InetSocketAddress(6666));
        // blocking
        SocketChannel client = server.accept();  // blocking
        System.out.println(" get the file"); // get the file
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // read the buffer, write the data to destination
        while(client.read(buffer ) != -1){
            buffer.flip();
            outChannel.write(buffer);
            buffer.clear();
        }

        // tell the client that server end has received the file
        buffer.put("get the file".getBytes());
        buffer.flip();
        client.write(buffer);
        buffer.clear();

        outChannel.close();
        client.close();
        server.close();




    }
}
