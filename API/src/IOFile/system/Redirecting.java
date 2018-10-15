package IOFile.system;

import java.io.*;

public class Redirecting {
    public static void main(String[] args) throws IOException {
        PrintStream console = System.out;
        if(! (new File("redirecting.txt").exists())) new File("redirecting.txt").createNewFile();
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("redirecting.txt"));
        PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("test.out")));

        System.setIn(in);
        System.setOut(out);
        System.setErr(out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while((s = br.readLine()) != null){
            System.out.println(s);
            out.close();
            System.setOut(console);
        }
    }
}
