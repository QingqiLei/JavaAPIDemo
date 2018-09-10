package container.properties;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * public class Properties
 * extends Hashtable
 */
public class PropertiesD {
    private static void writeConfig(String version, String username, String password) throws IOException {
        Properties p = new Properties();
        p.put("app.version", version);
        p.put("db.username", username);
        p.put("db.password", password);
        System.out.println("deleteIfExists: " + Files.deleteIfExists(Paths.get("API/src/container/properties/", username + ".properties")));
        System.out.println("createFile: " + Files.createFile(Paths.get("API/src/container/properties/", username + ".properties")));

        OutputStream out = new FileOutputStream("API/src/container/properties/" + username + ".properties");
        p.store(out, "create config");
        out.close();
    }

    private static void readConfig(String username) throws IOException {
        Properties p = new Properties();
        InputStream in = new FileInputStream("API/src/container/properties/" + username + ".properties");
        p.load(in);

        System.out.println("getProperty: " + p.getProperty("app.version") + " " + p.getProperty("db.username") + " " + p.getProperty("db.password"));
        in.close();
    }

    public static void main(String[] args) throws IOException {
        writeConfig("2", "admin", "234");
        readConfig("admin");
    }
}
