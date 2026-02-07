package src.generics.tests;

import java.util.LinkedList;
import java.util.List;

public class GenericsTest {
    public static void main(String[] args) {
        // Type erasure
        List<String> names = new LinkedList<>();
        names.add("AFF");
        names.add("Chupa");

        System.out.println(names);
    }
}
