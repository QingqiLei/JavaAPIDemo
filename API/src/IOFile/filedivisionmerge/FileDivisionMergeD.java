package IOFile.filedivisionmerge;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

public class FileDivisionMergeD {
    private static void division(File targetFile, long cutSize) throws IOException {
        if (targetFile == null) return;
        // compute the number of file
        int num = targetFile.length() % cutSize == 0 ? (int) (targetFile.length() / cutSize) : (int) (targetFile.length() / cutSize + 1);
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(targetFile));
        BufferedOutputStream out;

        byte[] bytes; // read the byte every time
        int len;      // read length in bytes
        int count;    // = cutSize / bytes.length


        for (int i = 0; i < num; i++) {
            out = new BufferedOutputStream(new FileOutputStream(new File((i + 1) + targetFile.getName())));
            // inside the for loop, there is the function to read the source and write every parts
            // here we compute the bytes and count,


            if (cutSize >= 1024) {
                bytes = new byte[1024];
                count = (int) cutSize / 1024; // the real copy might be count + 1,
            } else {  // each the file is less than cutSize
                bytes = new byte[(int) cutSize];
                count = 1;
            }

            // first check the count, second read the data to bytes array
            while (count > 0 && (len = in.read(bytes)) != -1) {
                out.write(bytes, 0, len);
                out.flush();
                count--;

            }
            // if the
            if (cutSize % 1024 != 0) {
                bytes = new byte[(int) cutSize % 1024];
                len = in.read(bytes);
                out.write(bytes, 0, len);
                out.close(); // close() is included the flush()
            }
            out.close();
        }
        in.close();

    }

    private static void merge(Enumeration<InputStream> es) throws IOException {
        SequenceInputStream sis = new SequenceInputStream(es);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("合并结果.mp4"));
        byte[] bytes = new byte[1024];
        int len;
        while ((len = sis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }
        bos.close();
        sis.close();
    }

    public static void main(String[] args) throws IOException {
        File file = new File("F:\\第08章 文件与IO_01_File类的使用.mp4");
        division(file, 1024 * 1024 * 20); // 20MB

        InputStream in1 = new FileInputStream(new File("1第08章 文件与IO_01_File类的使用.mp4"));
        InputStream in2 = new FileInputStream(new File("2第08章 文件与IO_01_File类的使用.mp4"));

        Vector<InputStream> v = new Vector<>();
        v.add(in1);
        v.add(in2);
        Enumeration<InputStream> es = v.elements();
        merge(es);


    }
}