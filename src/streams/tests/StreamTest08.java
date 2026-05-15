package src.streams.tests;

import src.streams.domain.LightNovel;

import java.util.ArrayList;
import java.util.List;

public class StreamTest08 {
    private static final List<LightNovel> novels = new ArrayList<>(List.of(
            new LightNovel("Fullmetal Alchemist", 15.0),
            new LightNovel("Sword Art Online", 3.99),
            new LightNovel("Tensei Shittara Slime Datta Ken", 8.0),
            new LightNovel("Violet Evergaden", 5.99),
            new LightNovel("Overlord", 3.99),
            new LightNovel("No Game No Life", 2.99),
            new LightNovel("Kumo desugo ka, nani ka?", 1.99),
            new LightNovel("Kumo desugo ka, nani ka?", 1.99),
            new LightNovel("Monogatari", 4.00)
    ));

    public static void main(String[] args) {

        double sum = novels.stream()
                .mapToDouble(LightNovel::getPrice)
                .filter(price -> price > 3)
                .sum();

        System.out.println(sum);
    }
}
