package src.optional.repositories;

import src.optional.domain.Manga;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class MangaRepository {
    public static List<Manga> mangas = new ArrayList<>(List.of(
            new Manga(1, "Oshi no Ko", 90),
            new Manga(2, "Overlord", 25),
            new Manga(3, "Sono Bisque Doll", 115)
    ));

    public static Optional<Manga> findBy(Predicate<Manga> predicate){
        Manga founded = null;

        for(Manga manga : mangas){
            if(predicate.test(manga)){
                founded = manga;
                break;
            }
        }
        return Optional.ofNullable(founded);
    }

    public static Optional<Manga> findByTitle(String title){
        return findBy(m -> m.getTitle().equals(title));
    }

    public static Optional<Manga> findById(Integer id){
        return findBy(m -> m.getId().equals(id));
    }

    public static void main(String[] args) {

    }

}
