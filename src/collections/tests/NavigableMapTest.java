package src.collections.tests;

import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapTest {
    public static void main(String[] args) {
        NavigableMap<String, String> map = new TreeMap<>();
        map.put("1chupa", "vai toma");
        map.put("2fodase", "eita");

        System.out.println(map);
    }
}
