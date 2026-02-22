package src.exercicios.lambdas;

import src.exercicios.lambdas.domain.Book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Exercise02 {
    /*
    Escreva um pipeline de Stream que receba uma List<Book>,
    utilize flatMap para extrair todos os autores de forma isolada,
    garanta que não haja autores repetidos no fluxo (distinct),
    ordene-os alfabeticamente e gere uma Map<Character,
    List<String>> onde a chave é a primeira letra do nome do autor (Character) e o valor é a lista de
    autores que começam com aquela letra.
    (Dica: utilize Collectors.groupingBy).
     */

    private static final List<Book> books = new ArrayList<>(
            List.of(
                    new Book("Zelda", 1995, List.of("Armandi", "Zelenski")),
                    new Book("OSkary", 1967, List.of("Zumandyas", "Skkeel")),
                    new Book("Whereve your go, i'll too", 1993, List.of("Nemesis", "Solares"))
            )
    );

    public static void main(String[] args) {
        Map<Character, List<Book>> result =
                books.stream()
                        .flatMap(book ->
                                book.getAuthors().stream()
                                        .map(author -> Map.entry(author.charAt(0), book))
                        )
                        .collect(Collectors.groupingBy(
                                Map.Entry::getKey,
                                Collectors.mapping(Map.Entry::getValue, Collectors.toList())
                        ));

        System.out.println(result);

    }
}
