package IOFile.objectstream;


import java.io.Serializable;

public class HomeDog extends Dog implements Serializable {
    transient private final int num;
    String name;

    public int getNum() {
        return num;
    }

    public HomeDog(String name, int num) {
        this.name = name;

        System.out.println("子类的构造函数");
        this.num = num;
    }

    @Override
    public String toString() {
        return "HomeDog{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}';
    }
}


