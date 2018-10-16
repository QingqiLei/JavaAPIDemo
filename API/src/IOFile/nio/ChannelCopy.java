package IOFile.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.sql.SQLOutput;

/**
 * In traditional IO, when the application use read() method, it needs to wait. the System will search the data in kernel memory, copy the data into user memory, this waiting is a necessary process
 */
public class ChannelCopy {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception {
//        if(args.length != 2){
//            System.out.println("argument, sourcefile destfile");
//            System.exit(1);
//        }
        FileChannel in = new FileInputStream(args[0]).getChannel(),
                out = new FileOutputStream(args[1]).getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
//        while(in.read(buffer) != -1){
//            buffer.flip();
//            out.write(buffer);
//            buffer.clear();
//
//
//        }
        in.transferTo(0, in.size(), out);
    }
}

/**
 * three  mold  of IO
 *
 * blocking IO
 * non-blocking IO
 *  多路复用IO
 *
 *  阻塞： 当进程（用户）空间调用recvfrom， 其系统调用知道数据包到达且被复制到应用进程的缓冲区中  或  发生错误时才返回，   在此期间一直等待
 *
 *  非阻塞： 从应用层到内核的时候，如果没有数据就直接返回一个EWOULDBLOCK 错误， 一般都对非阻塞I/O 模型进行轮询检查这个状态，看内核是不是有数据到来
 *
 *  NIO consisted of channel buffer selector
 */