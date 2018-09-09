package IOFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileDemo {
    public static void main(String[] args) throws IOException {
        File fi = new File("1.txt");
        System.out.println("whether 1.txt exist or not : "+fi.exists());
        if(!fi.exists()){
            fi.createNewFile();
            System.out.println("file is created successfully");
        }

        System.out.println("isDirectory(): "+fi.isDirectory());
        System.out.println("length()： "+ fi.length());
        System.out.println("getAbsolutePath(): "+fi.getAbsolutePath());
        System.out.println("delete(): "+fi.delete());

        File f2 = new File("API");
        File[] name = f2.listFiles();
        System.out.println("the file in API: "+ Arrays.toString(name));
        File f3 = new File("temp");
        System.out.println("mkdir(): "+f3.mkdir());

        System.out.println("renameTo: "+f3.renameTo(new File("tempp")));
        System.out.println("delete():"+new File("tempp").delete());
        System.out.println("delete(): "+f3.delete());
        File f4 = new File("API/src/container");
        File[] files = f4.listFiles((pathname)->pathname.getName().endsWith("java"));


        for(File f: files){
            System.out.print("endwith java: "+f.getName()+"|");

        }


    }
}
