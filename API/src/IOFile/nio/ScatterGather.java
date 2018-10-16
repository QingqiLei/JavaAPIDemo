package IOFile.nio;




import java.io.*;
import java.nio.ByteBuffer;

import java.nio.channels.FileChannel;

/**
 * scatter ； using one channel read several buffers
 * gather : write several buffer into one channel
 */
public class ScatterGather {


    public static void main(String[] args) throws IOException {
        if(!(new File("mapSource.txt").exists())) new File("mapSource.txt").createNewFile();
        FileChannel fcIn = new FileInputStream("mapSource.txt").getChannel();

        FileChannel fcOut = new FileOutputStream(("F:\\mapTarget.txt")).getChannel();

//        fcOut.position(fcOut.size());  I don't way this didn't work
        fcOut.write(ByteBuffer.wrap("channel ".getBytes()));
        ByteBuffer buf1 = ByteBuffer.allocate(1024);
        ByteBuffer buf2 = ByteBuffer.allocate(100);
        ByteBuffer[] bufs = {buf1, buf2};

        while(fcIn.read(bufs) != -1){
            for(ByteBuffer byteBuffer: bufs){
                byteBuffer.flip();
            }

            fcOut.write(bufs);
            for(ByteBuffer byteBuffer: bufs){
                byteBuffer.clear();
            }
        }







    }
}
