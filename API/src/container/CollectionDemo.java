package container;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CollectionDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(4);
        list.add(3);
        Collections.reverse(list); // 反转
        System.out.println("reverse " + list);
        Collections.shuffle(list); // 打乱顺序
        System.out.println("shuffle " + list);
        Collections.sort(list);
        System.out.println("sort " + list);
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("sort " + list);
        Collections.swap(list, 0, 2);
        System.out.println("swap " + list);
        Collections.rotate(list, 1);
        System.out.println("rotate " + list);
        System.out.println("binarySearch " + Collections.binarySearch(list, 1));
        System.out.println("max " + Collections.max(list));
        Collections.fill(list, 1);
        System.out.println("fill " + list);
        System.out.println("frequency " + Collections.frequency(list, 1));
        Collections.replaceAll(list, 1, 2);
        System.out.println("repalceAll " + list);

    }
}
