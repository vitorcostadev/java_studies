package src.collections.tests;

import src.collections.domain.Manga;
import src.collections.domain.Smartphone;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

class SmartphoneById implements Comparator<Smartphone>{
    @Override
    public int compare(Smartphone one, Smartphone two){
        return one.getSerialNumber().compareTo(two.getSerialNumber());
    }
}

class MangaByValue implements Comparator<Manga>{
    @Override
    public int compare(Manga o1, Manga o2) {
        return Double.compare(o1.getValue(), o2.getValue());
    }
}

public class NavigableSetTest {
    public static void main(String[] args) {
        NavigableSet<Smartphone> set = new TreeSet<>(new SmartphoneById());
        Smartphone motorola = new Smartphone("10sss", "Motorola");
        set.add(motorola);

        NavigableSet<Manga> mangas = new TreeSet<>(new MangaByValue());
        mangas.add(new Manga(1L, "Oshi no Ko", 45, 0));
        mangas.add(new Manga(2L, "Kaoru hana", 35, 5));
        mangas.add(new Manga(3L, "Sono bisque doll", 15, 0));
        mangas.add(new Manga(4L, "Frieren", 25, 2));

        System.out.println(mangas);

        // lower
        // floor
        // higher
        // ceiling


    }
}
