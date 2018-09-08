package annotation;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

@MyAnnotation( like = {"骨头","肉"},color = Color.YELLOW)
public class Dog implements Serializable, Comparable {
    private String name;
    private String[] like;
    private Color color;

    public Dog() {
    }

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", like=" + Arrays.toString(like) +
                ", color=" + color +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(name, dog.name) &&
                Arrays.equals(like, dog.like) &&
                color == dog.color;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, color);
        result = 31 * result + Arrays.hashCode(like);
        return result;
    }


    @Override
    public int compareTo(Object o) {
        return this.hashCode() - o.hashCode();
    }
}

