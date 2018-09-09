package container;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("good", "good", "study", "day", "day", "up");
        stream.forEach((str) -> System.out.print(str + " "));
        System.out.println();

        Stream<String> stream1 = Stream.of("good", "good", "study", "day", "day", "up");
        stream1.forEach(System.out::print);
        System.out.println();

        Stream<String> stream2 = Stream.of("good", "good", "study", "day", "day", "up");
        stream2.filter((s) -> s.length() > 3).forEach(System.out::print);
        System.out.println();

        Stream<String> stream3 = Stream.of("good", "good", "study", "day", "day", "up");
        stream3.distinct().forEach(s -> System.out.print(s + " "));
        System.out.println();

        Stream<String> stream4 = Stream.of("good", "good", "study", "day", "day", "up");
        stream4.map(s -> s.toUpperCase()).forEach(s -> System.out.print(s + " "));
        System.out.println();

        Stream<List<Integer>> ss = Stream.of(Arrays.asList(1, 2, 3), Arrays.asList(4, 5));
        ss.flatMap(List -> List.stream()).forEach(s -> System.out.print(s + " "));
        System.out.println();

        Optional<String> opt = stream.reduce((s1,s2)->s1.length() >=s2.length()?s1:s2);

        /**
         *  :: use method
         *  use static method  Integer.valueOf
         *  use Object method  list:add
         *  use constructor method  ArrayList::new
         */
    }
}
