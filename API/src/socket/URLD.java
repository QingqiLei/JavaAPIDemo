package socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLD {
    public static void main(String[] args) {
        try {

            URL url = new URL(" ");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            BufferedInputStream in = new BufferedInputStream(conn.getInputStream());

            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("c:\\yield.jpg"));
            byte[] bytes = new byte[1024];
            int len = -1;
            while ((len = in.read(bytes)) != -1) {
                out.write(bytes, 0, len);
                out.flush();
            }
            in.close();
            out.close();
            System.out.println("download successfully");


        } catch (Exception e) {

        }
    }
}
