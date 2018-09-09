package container;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {
    public static void main(String[] args) {


        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Tom");
        map.put(2, "Jack");
        map.put(3, "Vince");
        map.put(4, "Bin");
        map.put(5, "Lily");
        System.out.println("size = " + map.size());
        System.out.println("get " + map.get(200));
        map.compute(1, (k, v) -> v + "1");
        System.out.println("compute " + map.get(1));
        map.computeIfAbsent(6, (val) -> val + "test");
        System.out.println("computeIfAbsent " + map.get(6));
        map.merge(1, "888", (old, newv) -> old.concat(newv));
        System.out.println("merge " + map.get(1));

        System.out.println("+++++ entrySet +++++\n");
        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        for (Map.Entry e : entrySet) {
            System.out.println(e.getKey() + " " + e.getValue());
        }

        System.out.println("++++ KeySet ++++\r\n");
        Set<Integer> keyset = map.keySet();
        for (Integer i : keyset) {
            System.out.println(i + " " + map.get(i));
        }
        System.out.println("++++ values ++++\n");
        Collection<String> values = map.values();
        for (String value : values) {
            System.out.println(value);
        }

        System.out.println("++++ forEach ++++");
        map.forEach((key, value) -> System.out.println(key + " " + value));

    }
}
