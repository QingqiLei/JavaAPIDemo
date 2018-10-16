package IOFile.nio;


import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/***
 * buffer  Channel  Selector
 *  Channel -> transportation
 *  buffer -> data
 *   the Channel is bidirectional
 *   buffer is a abstract class, and ByteBuffer is used most frequent
 *
 *   channel is only responsible for transporting the data,not operating the data
 *
 *   Capacity: the maximum number that buffer can can hold
 *   limit: che number of data in buffer
 *   position: the next position that data will be written in or read
 *
 */

public class ChannelD {
    public static void main(String[] args) throws Exception {
        ByteBuffer buf = ByteBuffer.allocate(8);

        System.out.println("position = " + buf.position()); // 0
        System.out.println("limit = " + buf.limit());       // 8
        System.out.println("capacity = " + buf.capacity()); // 8

        buf.put((byte) 10);
        buf.put((byte) 20);
        buf.put((byte) 30);
        buf.put((byte) 40);
        buf.put((byte) 50);
        buf.put((byte) 40);

        System.out.println();
        System.out.println("position = " + buf.position()); // 6
        System.out.println("limit = " + buf.limit());       // 8
        System.out.println("capacity = " + buf.capacity()); // 8
        // after flip(), limit is the start of the data, the position the the end of the data, means that we can read from position to limit
        buf.flip();  // set position = 0, set limit = position, so that the data between position and limit is the real data
        // and we can call flip() operation that switches to reading state
        System.out.println();
        System.out.println("position = " + buf.position()); // 0
        System.out.println("limit = " + buf.limit());       // 6
        System.out.println("capacity = " + buf.capacity() + "\r\n"); // 8

        // Tells whether there are any elements between the current position and the limit.
        if (buf.hasRemaining()) {
            // buffer is a array, so we can get data from buffer in this way
            for (int i = 0; i < buf.remaining(); i++) {
                byte b = buf.get(i);
                System.out.print(b + " ");
            }
        }

        System.out.println("\r\n\r\nposition = " + buf.position()); // 0
        System.out.println("limit = " + buf.limit());       // 6
        System.out.println("capacity = " + buf.capacity() + "\r\n"); // 8

        if (buf.hasRemaining()) {  // if the data is not cleared, we can read the data again
            // buffer is a array, so we can get data from buffer in this way
            for (int i = 0; i < buf.remaining(); i++) {
                byte b = buf.get(i);
                System.out.print(b + " ");
            }
        }

        buf.clear(); // after clear, the data is still in the buffer array, but we set the position 0, and limit 8
        System.out.println("\r\n\r\nposition = " + buf.position()); // 0
        System.out.println("limit = " + buf.limit());       // 8
        System.out.println("capacity = " + buf.capacity() + "\r\n"); // 8
        copyFile();
    }

    // NIO
    private static void copyFile() throws Exception {
        File file = new File("mapSource.txt");
        System.out.println(file.getAbsolutePath());
        if (!file.exists()) file.createNewFile();
        Files.write(Paths.get("mapSource.txt"), "hadfhfdlj;kkkkkkkkkkkkkkk\r\n".getBytes(), StandardOpenOption.APPEND);

        // get channel
        FileChannel fcIn = new FileInputStream("mapSource.txt").getChannel();
        FileChannel fcOut = new FileOutputStream("F:\\mapTarget.txt").getChannel();

        // get the specific ByteBuffer
        ByteBuffer buf = ByteBuffer.allocate(1024);

        // channel.read(buf) means,  let channel put the data in buffer (array)
        // the no data, return -1
        while (fcIn.read(buf) != -1) {
            buf.flip(); // switches to reading mode
//            System.out.println("inside");
//            System.out.println("position = "+buf.position()); // 25
//            System.out.println("limit = "+buf.limit());       // 1024
//            System.out.println("capacity = "+buf.capacity()+"\r\n"); // 1024
            fcOut.write(buf);  // write the data from buffer to channel
            buf.clear(); // clear buffer


        }

//        fcIn.transferTo(0,fcIn.size(),fcOut); // we can use this the replace the while loop
        fcIn.close();
        fcOut.close();
        System.out.println("copy success");

//        file.delete();
        Files.deleteIfExists(Paths.get("F:\\1.txt"));
    }


}
