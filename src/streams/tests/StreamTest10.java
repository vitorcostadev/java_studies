package src.streams.tests;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class StreamTest10 {
    public static void main(String[] args) {
        Stream.iterate(1, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("-----------------------");

        Stream.iterate(new int[]{0,1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(10)
                .map(arr -> arr[0])
                .forEach(System.out::println);

        System.out.println("-----------------------");
        ThreadLocalRandom random = ThreadLocalRandom.current();

        Stream.generate(() -> random.nextInt(500))
                .limit(90)
                .forEach(System.out::println);
    }
}
