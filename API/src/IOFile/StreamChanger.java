package IOFile;

import java.io.*;
import java.nio.charset.Charset;

public class StreamChanger {
    // change FileInputStream stream to FileReader
    private static void read(InputStream in) throws IOException {
        Reader reader = new InputStreamReader(in, Charset.forName("utf-8"));
        char[] cs = new char[1024];
        int len = -1;
        while ((len = reader.read(cs)) != -1)
            System.out.println(new String(cs, 0, len));
        reader.close();
    }

    public static void write(OutputStream out) throws IOException{
        Writer writer = new OutputStreamWriter(out, Charset.defaultCharset());
        writer.write("小河\r\n");
        writer.write("哈哈\r\n");
        writer.close();
    }
    public static void main(String[] args) throws IOException {
        File f1 = new File("1.txt");
        f1.createNewFile();

        OutputStream out = new FileOutputStream(f1);
        write(out);

        InputStream in = new FileInputStream(f1);
        read(in);

    }
}
