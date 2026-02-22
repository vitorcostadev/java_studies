package src.streams.tests;

import src.streams.domain.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamTest {
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
        novels.sort(Comparator.comparing(LightNovel::getTitle));
        novels.forEach(System.out::println);

        List<String> novelTitle = new ArrayList<>();
        for(LightNovel ln : novels){
            if(ln.getPrice() <= 4){
                novelTitle.add(ln.getTitle());
            }
            if(novelTitle.size() >= 3) break;
        }

        novelTitle.forEach(System.out::println);
    }
}
