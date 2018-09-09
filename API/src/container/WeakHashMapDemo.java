package container;

import java.util.WeakHashMap;

public class WeakHashMapDemo {
    public static void main(String[] args) {
        int size = 10;

        Key[] keys = new Key[size];
        WeakHashMap<Key, Value> map = new WeakHashMap<>();
        for (int i = 0; i < size; i++) {
            Key k = new Key(Integer.toString(i));
            Value v = new Value(Integer.toString(i));

            if (i % 3 == 0) {// 3 的倍数就加入到数组keys中
                keys[i] = k;

            }
            map.put(k, v);

        }
        System.gc();
        // run for some time so that the element in the map can be recycled
        int j = 34;
        for (int i = 0; i < 1000000; i++) {
            j = i + 1 + 2;
        }

    }
}

class Element {
    private String ident;

    public Element(String id) {
        ident = id;
    }

    public String toString() {
        return ident;
    }

    public int hashCode() {
        return ident.hashCode();
    }

    public boolean equals(Object r) {
        return r instanceof Element && ident.equals(((Element) r).ident);
    }

    protected void finalize() {

        System.out.println("Finalizing" + getClass().getSimpleName() + " " + ident);

    }
}

class Key extends Element {
    public Key(String id) {
        super(id);
    }

}

class Value extends Element {
    public Value(String id) {
        super(id);
    }

}


