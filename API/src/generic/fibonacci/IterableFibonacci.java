package generic.fibonacci;

import java.util.Iterator;

public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {
    private int n;

    public IterableFibonacci(int count) {
        n = count;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n--;
                return IterableFibonacci.this.nect();
            }
        };

    }

    public static void main(String[] args) {
        for (int i : new IterableFibonacci(40))
            System.out.println(i + " ");
    }
}
