package IOFile.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class CharsetD {
    public static void main(String[] args) throws CharacterCodingException {
        Charset cs1 = Charset.forName("GBK");
        CharsetEncoder ce = cs1.newEncoder();
        CharsetDecoder cd = cs1.newDecoder();

        CharBuffer cBuf = CharBuffer.allocate(1024);
        cBuf.put("wojiao你好");

        System.out.println(cBuf.position() +" "+ cBuf.limit()+" "+cBuf.capacity());
        cBuf.flip();
        System.out.println(cBuf.position() +" "+ cBuf.limit()+" "+cBuf.capacity());

        ByteBuffer buf = ce.encode(cBuf);
        System.out.println(buf.position() +" "+ buf.limit()+" "+buf.capacity());
        CharBuffer charBuffer = cd.decode(buf);

        for(int i = 0; i < charBuffer.remaining();i++){
            System.out.print(charBuffer.get(i));
        }


    }
}
