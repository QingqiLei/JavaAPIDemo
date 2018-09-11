package reflection;

public class Dog {
    private String name;
    public int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog(String name) {
        this.name = name;
    }

    public Dog() {
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
    private void privateMethod(){
        System.out.println("privateMethod!");
    }
}
