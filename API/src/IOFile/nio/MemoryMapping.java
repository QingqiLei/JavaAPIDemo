package IOFile.nio;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public   class MemoryMapping {

    // memory mapping
    public static void main(String[] args) throws IOException {
        File file = new File("randomAccessSource.txt");
        if (!file.exists()) file.createNewFile();
        Writer writer = new FileWriter(file, true);
        writer.write("asdfghjklp\r\n");
        writer.close();


        RandomAccessFile in = new RandomAccessFile("randomAccessSource.txt", "r");
        RandomAccessFile out = new RandomAccessFile("F:\\randomAccessTarget.txt", "rw");

        // get channel
        FileChannel fcIn = in.getChannel();
        FileChannel fcOut = out.getChannel();

        long size = fcIn.size();
        System.out.println(size);

        MappedByteBuffer inBuf = fcIn.map(FileChannel.MapMode.READ_ONLY, 0, size);
        MappedByteBuffer outBuf = fcOut.map(FileChannel.MapMode.READ_WRITE, 0, size); //  the third element depends on  the data source( provider)

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
