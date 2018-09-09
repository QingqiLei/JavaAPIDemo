package objectoriented;

public interface InterfaceMain {
    void howdy();

    class Test implements InterfaceMain {

        @Override
        public void howdy() {
            System.out.println("Howdy! ");
        }

        public static void test() {
            System.out.println("my name is test");
        }

        public static void main(String[] args) {
            new Test().howdy();
            test();
        }
    }
}
