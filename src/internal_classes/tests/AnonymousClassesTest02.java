package src.internal_classes.tests;

import src.generics.domain.Barco;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AnonymousClassesTest02 {
    public static void main(String[] args) {
        List<Barco> barcos = new ArrayList<>(List.of(
                new Barco("Canoa"),
                new Barco("Koenigsegg")
        ));
        barcos.sort(new Comparator<Barco>() {
            @Override
            public int compare(Barco o1, Barco o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        System.out.println(barcos);
    }
}
