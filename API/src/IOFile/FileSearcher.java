package IOFile;

import java.io.File;

public class FileSearcher {
    public static void main(String[] args) {
        findFile(new File("F:\\"), ".pdf");
        findFile(null, ".pdf");
    }


    private static void findFile(File target, String ext) {
        if (target == null) {
            System.out.println("null+++++++++");
            return;
        }
        //如果文件是目录
        if (target.isDirectory()) {
            File[] files = target.listFiles();
            if (files != null) {
                for (File f : files) {
                    findFile(f, ext); // 递归调用
                }
            }
        } else { // 如果File 是一个文件
            String name = target.getName().toLowerCase();
            if (name.endsWith(ext)) {
                System.out.println(target.getAbsolutePath());
            }

        }
    }

}
