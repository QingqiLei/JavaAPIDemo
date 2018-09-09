package objectoriented;

public class InnerClassDemo {
    public static void main(String[] args) {
        // 使用Inner 成员内部类， 不建议这样在外部实例化内部类
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.print();

        outer.innerPrint(); // 使用成员内部类实例化的方法

        outer.show(); // 使用方法内部类

        Outer.Inner3 inner3 = new Outer.Inner3();// 使用静态内部类
        inner3.print();

        outer.print1();  // 内部类 继承

        outer.print2();  // 内部类 接口

        outer.print3(new Eat() {  // 内部类 参数式
            public void eat() {
                System.out.println("参数式匿名内部类");
//            System.out.println("参数式匿名内部类"+ name)  错误，参数式匿名内部类不能访问外部类的成员变量;
            }
        });
    }
}


class Outer {

    private static String name = "hahaaha";

    public void innerPrint() {
        // 使用Inner 成员内部类
        Inner inner = new Inner();
        inner.print();
    }

    // 成员内部类， 可以在外部类之外使用成员内部类， 也可以在外部类的方法中new， innerPrint()方法中使用
    public class Inner {
        public void print() {
            System.out.println("成员内部类 " + name);
        }
    }

    // 方法内部类， 在外部类的方法中定义一个类，并在方法中new，所以调用这个方法，就可以调用内部类
    // show方法的局部变量或方法的参数，实际必须是常量final， JDK1.8 中可以不加final，但默认final
    public void show() {
        /**final*/int x = 10;  // 可以访问, 但是能修改
        class Inner2 {
            //            x= x + 1; 出错
            public void print() {
                System.out.println("方法内部类 " + x + name);
            }
        }
        Inner2 inner2 = new Inner2();
        inner2.print();
    }

    // 静态内部类， 没有外部类的对象时，也能访问他，只能访问外部类的静态成员变量和方法,静态内部类就像是外部类，能够直接实例化。
    static class Inner3 {
        public void print() {
            System.out.println("静态内部类 " + name);
        }
    }

    // 匿名内部类
    // 继承式
    public void print1() {
        Cat cat = new Cat() {
            public void eat() {
                System.out.println("cat: 继承式匿名内部类 " + name);
            }
        }; // 一定加分号，因为这是一个语句
        cat.eat();
    }

    //接口式
    public void print2() {
        Eat eat = new Eat() {
            public void eat() {
                System.out.println("eat:接口式匿名内部类 " + name);
            }
        };
    }

    //有参数的，这里是把接口传进入
    public void print3(Eat eat) {
        eat.eat();
    }

}

abstract class Cat {
    public abstract void eat();
}

interface Eat {
    void eat();
}
