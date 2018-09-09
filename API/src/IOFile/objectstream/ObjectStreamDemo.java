package IOFile.objectstream;

import java.io.*;

public class ObjectStreamDemo {
    public static void writeObject() throws IOException {
        Dog dog = new HomeDog("大王",2);
        File file = new File("dog.obj");
        OutputStream out = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(dog);
    }

    public static void readObject() throws IOException, ClassNotFoundException {
        File file = new File("dog.obj");
        InputStream in = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(in);
        Dog dog = (Dog) ois.readObject();
        ois.close();
        System.out.println(dog);
        file.delete();

    }

    public static void main(String[] args) throws IOException,ClassNotFoundException{
        writeObject();
        readObject();
    }

}
