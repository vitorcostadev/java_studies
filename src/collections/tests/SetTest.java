package src.collections.tests;

import src.collections.domain.Manga;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        Set<Manga> mangas = new LinkedHashSet<>();
        mangas.add(new Manga(1L, "Oshi no Ko", 45, 0));
        mangas.add(new Manga(2L, "Kaoru hana", 35, 5));
        mangas.add(new Manga(3L, "Sono bisque doll", 35, 0));
        mangas.add(new Manga(4L, "Frieren", 45, 2));

        for (Manga manga : mangas) {
            System.out.println(manga);
        }
    }
}
