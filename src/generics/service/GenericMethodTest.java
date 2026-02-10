package src.generics.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class GenericMethodTest {
    public static void main(String[] args) {
        List<String> list = criarArray("Vai tomando", "vai toma sapeca");
        list.forEach(System.out::println);
    }

    @SafeVarargs
    private static <T> List<T> criarArray(T ...t){
        List<T> list = new ArrayList<>();
        if(t.length == 0) return list;

        Iterator<T> iterator = Arrays.stream(t).iterator();
        while(iterator.hasNext()){
            list.add(iterator.next());
        }
        return list;
    }
}
