package annotation;

import annotation.*;
import java.io.Serializable;
import java.util.Objects;

// 注解默认名字为dfdf
@MyAnnotation(name = "dfdf", like = {"gutou", "rou"},color = Color.RED)
public class Dog implements Serializable, Comparable {

    private static final long serialVersionUID = 2;

    private String name;
    private String[] like;
    private annotation.Color color;

    public Dog() {
    }

    public Dog(String name) {

        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getLike() {
        return like;
    }

    public void setLike(String[] like) {
        this.like = like;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(name, dog.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    private int privateMethod() {
        System.out.println("Dog 的私有方法");
        return 1;
    }

    @Override
    public int compareTo(Object o) {
        return this.hashCode() - o.hashCode();
    }
}

