package IOFile.copyFile;

import java.io.*;

public class CopyFileD {


    private static void copy(String src, String target) throws IOException{
        File srcFile = new File(src);
        File targetFile = new File(target);
        InputStream in = null;
        OutputStream out = null;

        try{
            in = new FileInputStream(srcFile);
            out = new FileOutputStream(targetFile);
            byte[] bytes = new byte[1024];
            int len;
            while((len = in.read(bytes))!= -1){ // read
                out.write(bytes,0,len);         // write
            }
        }finally{
            if(in != null) in.close();
            if(out != null) out.close();
        }
    }

    public static void main(String[] args) throws  IOException{
        File f1 = new File("1.txt");
        f1.createNewFile();
        copy("1.txt","2.txt");
        f1.delete();
        new File("2.txt").delete();
    }
}


