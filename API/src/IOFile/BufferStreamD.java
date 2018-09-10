package IOFile;

import java.io.*;

public class BufferStreamD {
    private static void byteWrite(File file) throws IOException {  // there is a few differences between bufferedStream and not buffered stream

        OutputStream out = new FileOutputStream(file, true);
        BufferedOutputStream bos = new BufferedOutputStream(out);
        bos.write("FileOutputStream\r\n".getBytes());
        bos.write("BufferedOutputStream\r\n".getBytes());
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
        bw.write("FileWriter\r\n");
        bw.write("BufferedWriter\r\n");
//        bw.close(); // if this stream is not closed, then the file will not be deleted, and there is a flush() method in output stream, and flush(0 is included in close(), if close() or flush() is not implemented at the last time writing, the data will only in buffer, not in file,
    }

    public static void main(String[] args) throws IOException {
        File file = new File("1.txt");
        if(!file.exists()) file.createNewFile();
        byteWrite(file);
        charWrite(file);
        byteReader(file);
        charRead(file);
        System.out.println(file.delete());
    }


}
