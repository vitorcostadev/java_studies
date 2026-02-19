package src.lambdas.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class LambdaTest02 {
    public static void main(String[] args) {
        List<String> names = List.of("Asuna", "Casadó", "KKKKKKKKK", "imagina nao amar java");
        map(names, String::toUpperCase)
                .forEach(System.out::println);
    }

    private static <T, R> List<R> map(List<T> list, Function<T, R> function){
        List<R> list1 = new ArrayList<>();

        list.forEach(obj -> {
            list1.add(function.apply(obj));
        });

        return list1;
    }
}
