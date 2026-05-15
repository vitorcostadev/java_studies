package src.streams.tests;

import src.streams.domain.Category;
import src.streams.domain.LightNovel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest12 {
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
        Map<Category, List<LightNovel>> categoryListMap = new HashMap<>();
        List<LightNovel> fantasy = new ArrayList<>();
        List<LightNovel> romance = new ArrayList<>();
        List<LightNovel> drama = new ArrayList<>();

        for(LightNovel novel : novels){
            switch(novel.getCategory()){
                case DRAMA -> drama.add(novel);
                case FANTASY -> fantasy.add(novel);
                case ROMANCE -> romance.add(novel);
            }
        }

        categoryListMap.put(Category.DRAMA, drama);
        categoryListMap.put(Category.ROMANCE, romance);
        categoryListMap.put(Category.FANTASY, fantasy);

        //System.out.println(categoryListMap);

        Map<Category, List<LightNovel>> collected = novels.stream()
                .collect(Collectors.groupingBy(LightNovel::getCategory));

        System.out.println(collected);
    }
}
