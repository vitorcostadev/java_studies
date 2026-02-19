package src.lambdas.tests;

import src.lambdas.domain.Anime;
import src.lambdas.service.AnimeComparators;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

// Reference to a constructor
public class MethodReferenceTest04 {
    public static void main(String[] args) {
        Supplier<AnimeComparators> newAnimeComparator = AnimeComparators::new;
        AnimeComparators animeComparators = newAnimeComparator.get();

        List<Anime> animes = new java.util.ArrayList<>(List.of(new Anime("Berserk", 23),
                new Anime("Oshi no Ko", 31),
                new Anime("Sono Bisque Doll", 23),
                new Anime("Umamusume: Pretty Derby", 18)));

        animes.sort(animeComparators::compareAnimesByEpisodesNonStatic);
        System.out.println(animes);

        BiFunction<String, Integer, Anime> animeBiFunction = Anime::new;
        System.out.println(animeBiFunction.apply("Owari no Seraph", 28));

    }
}
