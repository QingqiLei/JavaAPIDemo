package IOFile;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileD {
    public static void main(String[] args) throws IOException {
        File file = new File(System.getProperty("user.dir")+"\\1.txt");
        if(!file.exists()) file.createNewFile();

        RandomAccessFile w = new RandomAccessFile(System.getProperty("user.dir")+"\\1.txt" ,"rw");
        RandomAccessFile r = new RandomAccessFile("1.txt","r");

        w.writeUTF("RandomAccessFile Class");
        byte[] bytes = new byte[1024];
        int len;
        while((len = r.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }
        w.close();
        r.close();
        System.out.println(System.getProperty("user.dir"));
        file.delete();
    }
}
