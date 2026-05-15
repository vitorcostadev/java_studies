package src.streams.tests;

import java.util.List;

public class StreamTest07 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,3,4,5);
        numbers.stream().reduce((x,y) -> x * y)
                .ifPresent(System.out::println);
    }
}
