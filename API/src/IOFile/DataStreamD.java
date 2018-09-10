package IOFile;

import java.io.*;

public class DataStreamD {
    private static void read(File file) throws IOException {
        InputStream in = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(in);
        DataInputStream dis = new DataInputStream(bis);
        int num = dis.readInt();
        byte b = dis.readByte();
        String s = dis.readUTF();
        System.out.println(" " + num + b + s);
        dis.close();
    }

    private static void write(File file) throws IOException {
        OutputStream out = new FileOutputStream(file);
        BufferedOutputStream bos = new BufferedOutputStream(out);
        DataOutputStream dos = new DataOutputStream(bos);
        dos.writeInt(10);
        dos.writeByte(1);
        dos.writeUTF("中");
        dos.close();
    }

    public static void main(String[] args) throws IOException {
        File file = new File("1.txt");
        if (!file.exists()) file.createNewFile();

        write(file);
        read(file);


    }


}
