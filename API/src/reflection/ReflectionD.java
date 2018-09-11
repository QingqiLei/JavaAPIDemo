package reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.*;
import java.util.Arrays;

public class ReflectionD {

    @Test
    public void test1() {
        Dog dog1 = new Dog("Sam");
        Class dogClass = dog1.getClass();
        System.out.println(dogClass);

        Class dogClass1 = Dog.class;
        try {
            Class class1 = Class.forName("reflection.Dog");
            System.out.println(class1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        Class<Dog> dogClass = Dog.class;

        try {
            Dog dog = (Dog) dogClass.newInstance();
            System.out.println(dog);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3() {

        Class<Dog> dogClass = Dog.class;
        Constructor<?>[] constructors = dogClass.getConstructors();
        for (int i = 0; i < constructors.length; i++) {
            System.out.println(constructors[i].getName());
            System.out.println(constructors[i].getParameterCount());
        }
        Constructor<?> constructor;
        try {
            constructor = dogClass.getConstructor(String.class);
            Dog dog = (Dog) constructor.newInstance("Tom");
            System.out.println(dog);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4() {
        Class<Dog> dogClass = Dog.class;

        Field[] fields = dogClass.getFields();
        System.out.println("getFields().length: " + fields.length); // public field
        System.out.println("getFields(): " + Arrays.toString(fields));

        Field[] declaredFileds = dogClass.getDeclaredFields(); // all field
        System.out.println("getDeclaredFields().length: " + declaredFileds.length);
        System.out.println("getDeclaredFields(): " + Arrays.toString(declaredFileds));
        for (int i = 0; i < declaredFileds.length; i++) {
            int modifier1 = declaredFileds[i].getModifiers();
            System.out.println("getModifiers(): " + Modifier.toString(modifier1) + " + " + declaredFileds[i].getType() + " + " + declaredFileds[i].getName());
        }
    }

    @Test
    public void test5() {
        Dog testDog = new Dog("Dean");
        Class<Dog> dogClass = Dog.class;

        System.out.println("getPackage().getName(): " + dogClass.getPackage().getName());
        System.out.println("getMethods(): " + Arrays.toString(dogClass.getMethods())); // all methods including the base class method
        Method[] methods = dogClass.getMethods();
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].getName().equals("toString")) { // to find the toString() method
                try {
                    String s = (String) methods[i].invoke(testDog); // use toString() method
                    System.out.println(s); // toString()
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

        }
        System.out.println("+++++++      +++++++++");
        Method[] declaredMethods = dogClass.getDeclaredMethods(); // the class declared explicitly in the that class
        System.out.println(Arrays.toString(declaredMethods));
        for (int i = 0; i < declaredMethods.length; i++) {
            if (declaredMethods[i].getName().equals("privateMethod")) { // to find the privateMethod
                declaredMethods[i].setAccessible(true);                 // cause the method is private, so this operation is needed
                try {
                    declaredMethods[i].invoke(testDog);                 // use privateMethod() method
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
