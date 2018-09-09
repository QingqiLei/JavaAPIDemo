package container;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("1");
        Optional<String> optional2 = Optional.ofNullable("bin");
        Optional<String> optional3 = optional.empty();
        System.out.println("isPresent " + optional2.isPresent());
        System.out.println("isPresent " + optional3.isPresent());
        System.out.println("isPresent " + optional2.get());
        optional2.ifPresent((value) -> System.out.println("isPresent " + value));
        System.out.println(optional3.orElse("orElse " + "哈哈"));
        System.out.println(optional3.orElseGet(() -> "orElseGet default"));

        Optional<String> optional4 = optional2.map((value) -> value.toUpperCase());
        System.out.println("map " + optional4.get());

        Optional optional5 = optional4.flatMap((value) -> Optional.of(value.toUpperCase() + " flatMap"));
        System.out.println("flatMap " + optional5.get());

        System.out.println(optional2.filter((v) -> v.length() > 3).orElse("filter 这个值的长度小于4"));

    }
}
