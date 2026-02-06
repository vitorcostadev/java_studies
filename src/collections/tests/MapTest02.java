package src.collections.tests;

import src.collections.domain.Consumer;
import src.collections.domain.Manga;

import java.util.*;

public class MapTest02 {
    public static void main(String[] args) {
        Consumer consumer01 = new Consumer("Vitor");
        Consumer consumer02 = new Consumer("Ana");

        Manga oshiNoKo = new Manga(1L, "Oshi no Ko", 45, 0);
        Manga kaoruHana = new Manga(2L, "Kaoru hana", 35, 5);
        Manga sonoBisqueDoll = new Manga(3L, "Sono bisque doll", 35, 0);
        Manga frieren = new Manga(4L, "Frieren", 45, 2);

        Set<Manga> mangas = new TreeSet<>();
        mangas.add(oshiNoKo);
        mangas.add(kaoruHana);
        mangas.add(sonoBisqueDoll);
        mangas.add(frieren);

        Map<Consumer, Set<Manga>> consumerMangaMap = new LinkedHashMap<>();
        consumerMangaMap.put(consumer01, mangas);
        consumerMangaMap.put(consumer02, mangas);

        consumerMangaMap.forEach((key, value) -> {
            System.out.println(key.getName());
            System.out.println("-----------------------------");
            value.forEach(manga -> {
                System.out.println(manga.getName());
            });
            System.out.println("-----------------------------");
        });
    }
}
