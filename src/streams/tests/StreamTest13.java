package src.streams.tests;

import src.streams.domain.Category;
import src.streams.domain.LightNovel;
import src.streams.domain.Promotion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest13 {
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
        // agrupando utilizando objetos foras da classe LightNovel.

        Map<Promotion, List<LightNovel>> promotionListMap = novels.stream()
                .collect(Collectors.groupingBy(ln -> ln.getPrice() < 6 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE));

        System.out.println(promotionListMap);

        Map<Category, Map<Promotion, List<LightNovel>>> categoryMapMap = novels.stream()
                .collect(Collectors.groupingBy(LightNovel::getCategory,
                        Collectors.groupingBy(ln -> ln.getPrice() < 6 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE)));

        System.out.println(categoryMapMap);
    }
}
