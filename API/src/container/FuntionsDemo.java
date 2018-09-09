package container;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FuntionsDemo {

    // this method has no implement
    private static String strToUpp(String str, Function<String, String> f) {
        return f.apply(str);
    }

    @Test
    public void functionTest() {
        String s = strToUpp("qf_vince", (str) -> str.toUpperCase());
        System.out.println(s);
    }

    @Test
    public void supplierTest() {
        List<Integer> list = getNums(10, () -> (int) (Math.random() * 20));
        list.forEach(System.out::println);
    }

    // supplier with no implment
    private static List<Integer> getNums(int num, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(sup.get());

        }
        return list;
    }

    @Test
    public void predicateTest() {
        List<String> list = Arrays.asList("Larry", "Moe", "Curly", "Tom", "Qf_vince");
        filterTest(list, (s) -> s.contains("e")).forEach(System.out::println);
    }

    private static List<String> filterTest(List<String> list, Predicate<String> p) {
        List<String> results = new ArrayList<>();

        for (String s : list) {
            if (p.test(s))
                results.add(s);
        }
        return results;
    }

}
