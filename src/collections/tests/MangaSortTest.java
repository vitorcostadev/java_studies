package src.collections.tests;

import src.collections.domain.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class ManbaByIdComparator implements Comparator<Manga>{
    @Override
    public int compare(Manga o1, Manga o2) {
        return o1.getId().compareTo(o2.getId());
    }
}
public class MangaSortTest {
    public static void main(String[] args) {
        List<Manga> mangas = new ArrayList<>(6);
        mangas.add(new Manga(1L, "Oshi no Ko", 45));
        mangas.add(new Manga(2L, "Kaoru hana", 35));
        mangas.add(new Manga(3L, "Sono bisque doll", 35));
        mangas.add(new Manga(4L, "Frieren", 45));

        for (Manga manga : mangas) {
            System.out.println(manga);
        }
        System.out.println("=====================================");

        Collections.sort(mangas);
        for (Manga manga : mangas) {
            System.out.println(manga);
        }

        System.out.println("=====================================");

        Collections.sort(mangas, new ManbaByIdComparator());
        for (Manga manga : mangas) {
            System.out.println(manga);
        }
    }
}
