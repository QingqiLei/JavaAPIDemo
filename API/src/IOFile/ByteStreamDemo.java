package IOFile;

import java.awt.*;
import java.io.*;

public class ByteStreamDemo {
    private static void out() throws IOException {
        File file = new File("1.txt");
        if (!file.exists()) file.createNewFile();
        // true means appending the stream content to the tail
        OutputStream out = new FileOutputStream(file, true);
        String info = "soy milk\r\n";
        out.write(info.getBytes());
        out.write(info.getBytes());
        out.close();

    }

    private static void in() throws IOException {
        File file = new File("1.txt");
        InputStream in = new FileInputStream(file);
        byte[] bytes = new byte[10];                   // first
        StringBuilder buf = new StringBuilder();
        int len;
        while ((len = in.read(bytes)) != -1) {           // second
            buf.append(new String(bytes, 0, len));      // third

        }
        in.close();
        System.out.println(buf);
        file.delete();
    }


    public static void main(String[] args) throws IOException {
        out();
        in();
    }
}
