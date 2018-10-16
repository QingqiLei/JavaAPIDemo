package IOFile.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


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
        buf.flip();  // set position = 0, set limit = position, so that the data between position and limit is the real data
        System.out.println();
        System.out.println("position = " + buf.position()); // 0
        System.out.println("limit = " + buf.limit());       // 6
        System.out.println("capacity = " + buf.capacity() + "\r\n"); // 8

        // Tells whether there are any elements between the current position and the limit.

        if (buf.hasRemaining()) {
            //
            for (int i = 0; i < buf.remaining(); i++) {
                byte b = buf.get(i);
                System.out.print(b + " ");
            }
        }

        System.out.println("\r\n\r\nposition = " + buf.position()); // 6
        System.out.println("limit = " + buf.limit());       // 8
        System.out.println("capacity = " + buf.capacity() + "\r\n"); // 8
        copyFile();
        randomAccessFileCopy();
    }

    // NIO
    private static void copyFile() throws Exception {
        File file = new File("mapSource.txt");
        if (!file.exists()) file.createNewFile();
        Files.write(Paths.get("mapSource.txt"), "hadfhfdlj;kkkkkkkkkkkkkkk\r\n".getBytes(), StandardOpenOption.APPEND);

        FileChannel fcIn = new FileInputStream("mapSource.txt").getChannel();
        FileChannel fcOut = new FileOutputStream("F:\\mapTarget.txt").getChannel();

        ByteBuffer buf = ByteBuffer.allocate(1024);

        while (fcIn.read(buf) != -1) {
            buf.flip();
//            System.out.println("inside");
//            System.out.println("position = "+buf.position()); // 25
//            System.out.println("limit = "+buf.limit());       // 1024
//            System.out.println("capacity = "+buf.capacity()+"\r\n"); // 1024
            fcOut.write(buf);
            buf.clear();
        }
        fcIn.close();
        fcOut.close();
        System.out.println("copy success");

//        file.delete();
//        Files.deleteIfExists(Paths.get("F:\\1.txt"));
    }

    // memory mapping
    private static void randomAccessFileCopy() throws IOException {
        File file = new File("randomAccessSource.txt");
        if (!file.exists()) file.createNewFile();
        Writer writer = new FileWriter(file, true);
        writer.write("asdfghjklp\r\n");
        writer.close();

        RandomAccessFile in = new RandomAccessFile("randomAccessSource.txt", "r");
        RandomAccessFile out = new RandomAccessFile("F:\\randomAccessTarget.txt", "rw");

        FileChannel fcIn = in.getChannel();
        FileChannel fcOut = out.getChannel();

        long size = fcIn.size();
        System.out.println(size);
        MappedByteBuffer inBuf = fcIn.map(FileChannel.MapMode.READ_ONLY, 0, size);
        MappedByteBuffer outBuf = fcOut.map(FileChannel.MapMode.READ_WRITE, 0, size);

        for (int i = 0; i < size; i++) {
            outBuf.put(inBuf.get());
        }
        // the data will be written when the channel is closed

        fcIn.close();
        fcOut.close();
        out.close();
        in.close();

//        System.out.println("delete: "+file.delete());
//        Files.deleteIfExists(Paths.get("F:\\randomAccessTarget.txt"));

        System.out.println("copy success");
    }
}
