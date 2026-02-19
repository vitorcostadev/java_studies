package src.lambdas.tests;

import src.lambdas.domain.Anime;
import src.lambdas.service.AnimeComparators;

import java.util.List;

// Reference to an instance method of a particular object
public class MethodReferenceTest02 {
    public static void main(String[] args) {
        AnimeComparators animeComparators = new AnimeComparators();
        List<Anime> animes = new java.util.ArrayList<>(List.of(new Anime("Berserk", 23),
                new Anime("Oshi no Ko", 31),
                new Anime("Sono Bisque Doll", 23),
                new Anime("Umamusume: Pretty Derby", 18)));
        animes.sort(animeComparators::compareAnimesByEpisodesNonStatic);
        System.out.println(animes);

    }
}
