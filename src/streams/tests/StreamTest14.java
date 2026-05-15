package src.streams.tests;

import src.streams.domain.Category;
import src.streams.domain.LightNovel;
import src.streams.domain.Promotion;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamTest14 {
    private static final List<LightNovel> novels = new ArrayList<>(List.of(
            new LightNovel("Fullmetal Alchemist", 15.0, Category.DRAMA),
            new LightNovel("Sword Art Online", 3.99, Category.FANTASY),
            new LightNovel("Tensei Shittara Slime Datta Ken", 8.0, Category.FANTASY),
            new LightNovel("Violet Evergaden", 5.99, Category.ROMANCE),
            new LightNovel("Overlord", 3.99, Category.FANTASY),
            new LightNovel("No Game No Life", 2.99, Category.DRAMA),
            new LightNovel("Kumo desugo ka, nani ka?", 1.99, Category.FANTASY),
            new LightNovel("Monogatari", 4.00, Category.ROMANCE)
    ));

    public static void main(String[] args) {
        Map<Category, Long> collected = novels.stream()
                .collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.counting()));

        System.out.println(collected);

        Map<Category, Optional<LightNovel>> doubleMap = novels.stream()
                .collect(
                        Collectors.groupingBy(LightNovel::getCategory,
                                Collectors.maxBy(
                                        Comparator.comparing(LightNovel::getPrice))));

        System.out.println(doubleMap);

        Map<Category, LightNovel> collect = novels.stream().collect(Collectors.toMap(LightNovel::getCategory, Function.identity(), BinaryOperator.maxBy(Comparator.comparing(LightNovel::getPrice))));
        System.out.println(collect);
    }
}
