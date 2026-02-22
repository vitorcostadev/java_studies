package src.streams.tests;

import src.streams.domain.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest02 {
    private static List<LightNovel> novels = new ArrayList<>(List.of(
            new LightNovel("Fullmetal Alchemist", 15.0),
            new LightNovel("Sword Art Online", 3D),
            new LightNovel("Tensei Shittara Slime Datta Ken", 8D),
            new LightNovel("Violet Evergaden", 5.99),
            new LightNovel("Overlord", 3.99),
            new LightNovel("No Game No Life", 2.99),
            new LightNovel("Kumo desugo ka, nani ka?", 1.99),
            new LightNovel("Monogatari", 4.00)
    ));

    public static void main(String[] args) {
        List<String> stringList = novels.stream()
                .sorted(Comparator.comparing(LightNovel::getTitle))
                .filter(ln -> ln.getPrice() <= 4)
                .limit(3)
                .map(LightNovel::getTitle)
                .collect(Collectors.toList());

        System.out.println(stringList);
    }
}
