package src.lambdas.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

// Reference to an instance method of an arbitrary object of a particular type
public class MethodReferenceTest03 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>(List.of("Asuna", "Ekil", "Shakira", "Luiza"));
        stringList.sort(String::compareTo);
        System.out.println(stringList);

        Function<String, Integer> StringToInteger = Integer::parseInt;
        System.out.println(StringToInteger.apply("225"));

        BiPredicate<List<String>, String> isNameInList = List::contains;
        System.out.println(isNameInList.test(stringList, "Ekil"));
    }
}
