package annotation;

import org.junit.jupiter.api.Test;

public class tester {

    @Test
    public void test1(){
       Class<Dog> dogClass = Dog.class;
       MyAnnotation annotation = dogClass.getAnnotation(MyAnnotation.class);
       String name = annotation.name();
       String[] like = annotation.like();
       Color color = annotation.color();

       try{
           Dog dog = dogClass.newInstance();
           dog.setColor(color);
           dog.setLike(like);
           dog.setName(name);
           System.out.println(dog);

       } catch (IllegalAccessException e) {
           e.printStackTrace();
       } catch (InstantiationException e) {
           e.printStackTrace();
       }

    }

}
