package src.lambdas.tests;

import src.lambdas.domain.Anime;
import src.lambdas.service.AnimeComparators;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Reference to a static method
public class MethodReferenceTest {
    public static void main(String[] args) {
        List<Anime> animes = new java.util.ArrayList<>(List.of(new Anime("Berserk", 23),
                new Anime("Oshi no Ko", 31),
                new Anime("Sono Bisque Doll", 23),
                new Anime("Umamusume: Pretty Derby", 18)));

        animes.sort(AnimeComparators::compare);
        animes.forEach(anime -> System.out.println(anime.getTitle()));
    }


}
