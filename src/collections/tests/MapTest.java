package src.collections.tests;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("teclado", "teklado");
        map.put("anime", "oshi no ko");
        map.put("futebol", "flamengo");

        map.keySet().forEach(key -> {
            System.out.println("Key="+key+", Value="+map.get(key));
        });

    }
}
