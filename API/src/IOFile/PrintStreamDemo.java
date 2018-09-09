package IOFile;

import java.awt.*;
import java.io.*;

public class PrintStreamDemo {
    private static void charPrint(File file) throws IOException{
        Writer out = new FileWriter(file);
        // buffered
        BufferedWriter bw = new BufferedWriter(out);
        // print
        PrintWriter ps = new PrintWriter(bw);
        ps.println("打印1");
        ps.println("打印2");
        ps.close();
    }

    private static void bytePrint(File file) throws IOException{
        OutputStream out = new FileOutputStream(file);
        // buffered
        BufferedOutputStream bos = new BufferedOutputStream(out);
        // print
        PrintStream ps= new PrintStream(bos);
        ps.println("打印");
        ps.close();
    }

    public static void main(String[] args) throws IOException {
        File file = new File("1.txt");
        if(!file.exists()) file.createNewFile();
        bytePrint(file);
        charPrint(file);
        file.delete();

    }
}
