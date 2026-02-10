package src.lambdas.tests;


import java.util.List;
import java.util.function.Consumer;

public class LambdaTest {
    public static void main(String[] args) {
        List<String> asuna = List.of("Asuna", "Keydrin", "Ai hoshino", "Ruby Hoshino");
        forEach(asuna, s -> System.out.println(s));
    }

    private static <T> void forEach(List<T> obj, Consumer<T> consumer){
        obj.forEach(o -> {
            consumer.accept(o);
        });
    }
}
