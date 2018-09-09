package IOFile;

import java.awt.*;
import java.io.*;

public class BufferStreamDemo {
    private static void byteWrite(File file) throws IOException {

        OutputStream out = new FileOutputStream(file, true);
        BufferedOutputStream bos = new BufferedOutputStream(out);
        bos.write("你好\r\n".getBytes());
        bos.close();
    }

    private static void byteReader(File file) throws IOException{
        InputStream in = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(in);
        byte[] bytes = new byte[1024];
        int len;
        while((len = bis.read(bytes))!= -1)
            System.out.println(new String(bytes,0,len));
        bis.close();
    }

    private static void charRead(File file) throws IOException{
        Reader reader = new FileReader(file);
        BufferedReader br = new BufferedReader(reader);
        char[] cs = new char[1024];
        int len;
        while((len = br.read(cs))!=-1)
            System.out.println(new String(cs,0,len));
        br.close();
    }

    private static void charWrite(File file) throws IOException{
        Writer write = new FileWriter(file,true);
        BufferedWriter bw = new BufferedWriter(write);
        bw.write("h哈哈\r\n");
        bw.write("h哈哈\r\n");
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        File file = new File("1.txt");
        if(!file.exists()) file.createNewFile();
        byteWrite(file);
        charWrite(file);
        byteReader(file);
        charRead(file);
        file.delete();
    }


}
