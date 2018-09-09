package container;

import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args){
        Stream<String> stream = Stream.of("good","good","study","day","day","up");
        stream.forEach((str)-> System.out.print(str+" "));

    }
}
