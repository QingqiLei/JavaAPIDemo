package container;

import org.junit.jupiter.api.Test;

import java.net.SocketTimeoutException;
import java.util.*;

public class ListDemo {

    @Test
    public void vector() {
        Vector<String> v = new Vector<>();
        v.add("1");
        v.add("2");
        v.add("3");
        for (int i = 0; i < v.size(); i++) {
            System.out.print(v.get(i) + " ");
        }
    }

    @Test
    public void arrayList() {
        List list = new ArrayList(100);
//        List list = new LinkedList(100);
        list.add("Lili1");
        list.add("Lili2");
        list.add("Lili3");
        list.add("Lili4");
        list.add(10);
        Object[] array = list.toArray();
        for (Object s : array) {
            System.out.println(s + " ");
        }

        System.out.println();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + " ");
        }
        System.out.println();

    }

    @Test
    public void queue() {

        // there is no Queue class in Java API, only a interface
        // use offer() instead of add(),
        // Queue has six unique methods, add() element() offer() peek() remove()

        Queue<String> q = new LinkedList<>();
        q.offer("1");
        q.offer("2");
        q.offer("3");
        System.out.println(q.offer("4"));
        System.out.println(q.add("2"));
        System.out.println(q.toString());
        System.out.println("peek " + q.peek()); // 1, peek() means get the first element in the queue
        System.out.println("size " + q.size()); // 4
        System.out.println("poll " + q.poll()); // 1
        System.out.println("size " + q.size()); // 3


    }

    @Test
    public void deque() {
        Deque<Integer> deque = new LinkedList<>();
        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.add(4);
        deque.add(5);
        deque.offer(6);

        System.out.println(Arrays.toString(deque.toArray()));
        deque.addFirst(7); // insert 7 to the first position
        System.out.println(Arrays.toString(deque.toArray()));

        deque.pollLast(); // get the Object in the last position
        System.out.println(Arrays.toString(deque.toArray()));


    }


}
