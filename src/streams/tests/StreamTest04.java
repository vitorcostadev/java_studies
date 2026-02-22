package src.streams.tests;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest04 {
    public static void main(String[] args) {
        List<List<String>> dev = new ArrayList<>();
        List<String> gameDeveloper = List.of("Skkz", "Onlyxier ZkaarFer");
        List<String> UiDeveloper = List.of("Jermision", "Skerlp", "Xaimin");
        List<String> students = List.of("XXaa", "Skler");

        dev.add(gameDeveloper);
        dev.add(UiDeveloper);
        dev.add(students);

        dev.stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);


    }
}
