package src.streams.tests;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest05 {
    public static void main(String[] args) {
        List<String> strings = List.of("Yoro", "Yoro", "No", "Mi");

        String[] split = strings.get(0).split("");
        System.out.println(Arrays.toString(split));

        List<String> stringList = strings.stream()
                .map(w -> w.split("")) // Stream<String[]>
                .flatMap(Arrays::stream) // Stream<String>
                .collect(Collectors.toList());

        System.out.println(stringList);
    }
}
