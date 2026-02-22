package src.optional.tests;

import java.util.List;
import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> op = findName("vsf");
        System.out.println(op);
    }

    private static Optional<String> findName(String name){
        List<String> names = List.of("Willian", "José");
        int i = names.indexOf(name);

        if(i != -1) return Optional.of(names.get(i));
        return Optional.empty();
    }
}
