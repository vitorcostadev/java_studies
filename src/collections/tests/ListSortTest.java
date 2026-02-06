package src.collections.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSortTest {
    public static void main(String[] args) {
        List<String> mangas = new ArrayList<>(6);
        mangas.add("Oshi no Ko");
        mangas.add("Kaoru hana");
        mangas.add("Sono bisque doll");
        mangas.add("Frieren");

        Collections.sort(mangas);

        List<Double> dindins = new ArrayList<>();
        dindins.add(100.21);
        dindins.add(83.24);
        dindins.add(623.23);
        dindins.add(212.23);

        Collections.sort(dindins);
        System.out.println(dindins);
        System.out.println(mangas);
    }
}
