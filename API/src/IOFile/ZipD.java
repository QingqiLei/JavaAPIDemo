package IOFile;

import javax.swing.*;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;


public class ZipD {
    /**
     * @param targetFile the file that is going to be compressed
     * @throws IOException
     */
    private static void compression(File targetFile) throws IOException {
        System.out.println("compressing...");

        ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(targetFile.getName() + ".zip"));
        BufferedOutputStream bos = new BufferedOutputStream(zout);


        zip(zout, targetFile, targetFile.getName(), bos);
        bos.close();
        zout.close();
        System.out.println("compressed successfully");
    }

    /**
     * @param zout       zipOutputStream
     * @param targetFile the file we want to compress
     * @param path       the relative path of the file we want to compress
     * @param bos        the stream we output the result
     * @throws IOException
     */
    private static void zip(ZipOutputStream zout, File targetFile, String path, BufferedOutputStream bos) throws IOException {

        if (targetFile.isDirectory()) {         // targetFile is a Directory, then get subfile, use zip method one by one
            File[] files = targetFile.listFiles();
            if (files.length == 0) // the directory is empty
                zout.putNextEntry(new ZipEntry(path = "/"));
            for (File f : files) // if the directory is empty, the files is empty
                zip(zout, f, path + "/" + f.getName(), bos);  // deep first

        } else {
            zout.putNextEntry(new ZipEntry(path)); //
            FileInputStream in = new FileInputStream(targetFile);
            BufferedInputStream bis = new BufferedInputStream(in);
            byte[] bytes = new byte[1024];
            int len = -1;

            while ((len = bis.read(bytes)) != -1)
                bos.write(bytes, 0, len);

            in.close();
            bis.close();
        }
    }

    /**
     * @param targetFileName
     * @param parent         the parent directory
     * @throws IOException
     */
    private static void decompression(String targetFileName, String parent) throws IOException {
        System.out.println("Decompressing...");
        ZipInputStream zin = new ZipInputStream(new FileInputStream(targetFileName));
        ZipEntry entry = null;
        File file = null;
        //
        while ((entry = zin.getNextEntry()) != null && !entry.isDirectory()) {
            file = new File(parent, entry.getName());
            if (!file.exists())
                new File(file.getParent()).mkdir();
            FileOutputStream out = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(out);
            byte[] bytes = new byte[1024];
            int len;
            while ((len = zin.read(bytes)) != -1)
                bos.write(bytes, 0, len);
            bos.close();
            out.close();
        }
        zin.close();
        System.out.println("Decompressed successfully!");
    }

    public static void main(String[] args) throws IOException {

        File file = new File(System.getProperty("user.dir") + "/11directory");
        if (!file.exists()) file.mkdir();

        File f1 = new File("11directory\\1.txt");
        if (!f1.exists()) f1.createNewFile();

        Writer out = new FileWriter(f1);
        out.write("zip test 2");
        out.close();

        compression(file);
        System.out.println("delete: "+f1.delete() + " " + file.delete());
        decompression("11directory.zip", System.getProperty("user.dir"));
        System.err.println("there are two file in the user dir, check them!");
    }
}
