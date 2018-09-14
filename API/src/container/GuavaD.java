package container;


import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.*;
import org.junit.jupiter.api.Test;


import java.text.SimpleDateFormat;
import java.util.*;


public class GuavaD {
    @Test
    public void unmidified() {

        // can not add or delete, but can modify
        List<String> list = Arrays.asList("Jack", "Tom", "Lily");
        list.set(0, "ja");
        System.out.println("asList: (can modify)" + list);

        // can not modify
        List<String> list1 = new ArrayList<>();
        list1.add("Jack");
        list1.add("Tom");
        list1.add("Lily");
        List<String> readList = Collections.unmodifiableList(list1);
        System.out.println("unmodifiableList():(can't modify) " + readList);

        ImmutableList<String> iList = ImmutableList.of("jack", "tom", "lily");
        System.out.println("ImmutableList():(can't modify)" + iList);
    }

    @Test
    public void filter1() {
        List<String> list = Lists.newArrayList("java", "php", "jack", "h5", "javascript");
        Collection<String> result = Collections2.filter(list, (e) -> e.startsWith("j"));
        result.forEach(System.out::println);
    }

    @Test
    public void convert1() {
        Set<Long> timeSet = Sets.newHashSet(1006008475911L, 1510888005911L, 1530888475911L);
        Collection<String> timeCollection = Collections2.transform(timeSet, (e) -> new SimpleDateFormat("yyyy-MM-dd").format(e));
        timeCollection.forEach(System.out::println);
    }

    @Test
    public void compose1() {
        List<String> list = Lists.newArrayList("java", "php", "jack", "h5", "javascript");
        Function<String, String> f1 = new Function<String, String>() {
            @Override
            public String apply(String s) {

                return s.length() > 4 ? s.substring(0, 5) : s;
            }
        };

        Function<String, String> f2 = new Function<String, String>() {
            @Override
            public String apply(String s) {

                return s.toUpperCase();
            }
        };

        Function<String, String> f = Functions.compose(f1, f2);

        System.out.println(Collections2.transform(list, f));
    }

    // intersection difference union
    @Test
    public void test() {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(4);
        set2.add(2);
        set2.add(3);

        Sets.SetView<Integer> V1 = Sets.intersection(set1, set2);
        System.out.print("intersection: ");
        V1.forEach(System.out::print);
        System.out.println();
        System.out.println("difference: " + Sets.difference(set1, set2));
        System.out.println("union: " + Sets.union(set1, set2));

        Set<Integer> s1 = new HashSet<>();
        s1.addAll(set1);
        s1.retainAll(set2);
        System.out.println("retainAll: " + s1);

        Set<Integer> s2 = new HashSet<>();
        s2.addAll(set1);
        s2.removeAll(set2);
        System.out.println("removeAll: " + s2);

        Set<Integer> s3 = new HashSet<>();
        s3.addAll(set1);
        s3.addAll(set2);
        System.out.println("addAll: " + s3);
    }

    // set's element can be repeatable
    @Test
    public void repeatableSet() {
        String s = "good good study day day up";
        String[] ss = s.split(" ");
        HashMultiset<String> set = HashMultiset.create();

        for (String str : ss) {
            set.add(str);
        }

        Set<String> set2 = set.elementSet();
        for (String str : set2) {
            System.out.println(str + ":" + set.count(str));
        }
    }

    // value can be repeatable
    @Test
    public void multimap() {
        Map<String, String> map = new HashMap<>();
        map.put("Java", "bin");
        map.put("Android", "bin");
        map.put("PHP", "Jack");
        map.put("Javascript", "Sam");

        Multimap<String, String> mmap = ArrayListMultimap.create();
        Iterator<Map.Entry<String, String>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, String> entry = iter.next();
            mmap.put(entry.getValue(), entry.getKey());
        }

        Set<String> keySet = mmap.keySet();
        for (String key : keySet) {
            System.out.println(key + ": " + mmap.get(key));
        }
    }

    // key and value can not repeat
    @Test
    public void BiMap() {
        BiMap<String, String> map = HashBiMap.create();
        map.put("finally_test", "18800208234");
        map.put("bin", "18800208456");
        map.put("sam", "18888888888");
        System.out.println(map.inverse().get("18800208456"));
        System.out.println(map.get("bin"));
    }

    // double key map
    @Test
    public void HashBasedTable() {
        Table<String, String, Integer> table = HashBasedTable.create();
        table.put("Jack", "java", 80);
        table.put("tom", "php", 90);
        table.put("lily", "php", 70);
        table.put("bin", "ui", 60);
        Set<Table.Cell<String, String, Integer>> cells = table.cellSet();
        for (Table.Cell c : cells) {
            System.out.println(c.getRowKey() + "-" + c.getColumnKey() + "-" + c.getValue());
        }

    }
}
