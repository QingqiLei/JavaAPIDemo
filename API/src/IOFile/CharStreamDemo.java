package IOFile;

import java.io.*;

public class CharStreamDemo {
    private static void out() throws IOException {
        File file = new File("1.txt");
        if (!file.exists()) file.createNewFile();
        Writer out = new FileWriter(file, true); // FileWriter  append
        out.write("某花到我家\r\n");
        out.write("啪啪啪\r\n");
        out.close();
    }

    private static void in() throws IOException { // the code of input of FileReader is similar with FileInputStream
        File file = new File("1.txt");
        Reader in = new FileReader(file);
        char[] cs = new char[1];
        int len;
        StringBuilder buf = new StringBuilder();
        while ((len = in.read(cs)) != -1)
            buf.append(new String(cs, 0, len));

        in.close();
        System.out.println(buf);
    }

    public static void main(String[] args) throws IOException {
        out();
        in();
    }
}
