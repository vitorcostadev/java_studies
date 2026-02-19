package src.lambdas.service;

import src.lambdas.domain.Anime;

public class AnimeComparators {
    public static int compare(Anime a1, Anime a2){
        return a1.getTitle().compareTo(a2.getTitle());
    }

    public int compareAnimesByEpisodesNonStatic(Anime a1, Anime a2){
        return Integer.compare(a1.getEpisodes(), a2.getEpisodes());
    }

    public static int compareAnimesByEpisodes(Anime a1, Anime a2){
        return Integer.compare(a1.getEpisodes(), a2.getEpisodes());
    }
}
