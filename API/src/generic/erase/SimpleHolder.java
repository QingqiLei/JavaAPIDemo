package generic.erase;



public class SimpleHolder {
    private Object obj;

    public void set(Object obj) {
        this.obj = obj;
    }

    public Object get() {
        return obj;
    }

    public static void main(String[] args) {
        SimpleHolder h = new SimpleHolder();
        h.set("item");
        String s = (String) h.get();  // examine the class type here
    }
}
