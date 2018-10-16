package IOFile.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * FileOutputStream
 * RandomAccessFile
 * FileInputStream
 */
public class GetChannel {
    private static final int BSIZE = 1024;
    public static void main(String[] args) throws Exception{

        FileChannel fc = new FileOutputStream("redirect.txt").getChannel();
        fc.write(ByteBuffer.wrap("some text".getBytes()));
        fc.close();

        fc = new RandomAccessFile("data.txt", "rw").getChannel();
        fc.position(fc.size());  // move to the end(the end of the file)
        fc.write(ByteBuffer.wrap("gg ".getBytes()));
        fc.close();
        // read the file

        fc = new FileInputStream("data.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocateDirect(BSIZE);
        fc.read(buff); // 调用read 告知FileChannel 向ByteBuffer 存储字节，
        buff.flip();
        while(buff.hasRemaining())
            System.out.print((char)buff.get());

    }
}
