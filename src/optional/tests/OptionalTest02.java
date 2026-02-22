package src.optional.tests;

import src.optional.domain.Manga;
import src.optional.repositories.MangaRepository;

import java.util.Optional;

public class OptionalTest02 {
    public static void main(String[] args) {
        MangaRepository.findByTitle("Oshi no Ko")
                .ifPresent(m -> m.setTitle("OSHI NO KO"));

        System.out.println(MangaRepository.mangas);

        Manga mangaById = MangaRepository.findById(3)
                .orElseThrow(IllegalArgumentException::new);

        Manga mangaByTitle = MangaRepository.findByTitle("Ao no Hako")
                .orElse(new Manga(MangaRepository.mangas.size(), "Ao no Hako", 125));

        System.out.println(mangaByTitle);
    }
}
