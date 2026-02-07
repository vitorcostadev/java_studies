package src.collections.tests;

import src.collections.domain.Manga;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {
    public static void main(String[] args) {
        List<Manga> mangas = new ArrayList<>(6);
        mangas.add(new Manga(1L, "Oshi no Ko", 45, 0));
        mangas.add(new Manga(2L, "Kaoru hana", 35, 5));
        mangas.add(new Manga(3L, "Sono bisque doll", 35, 0));
        mangas.add(new Manga(4L, "Frieren", 45, 2));

        Iterator<Manga> mangaIterator = mangas.iterator();
        while (mangaIterator.hasNext()){
            Manga next = mangaIterator.next();
            if(next.getQuantity() == 0){
                mangaIterator.remove();
            }
        }

        System.out.println(mangas);
    }
}
