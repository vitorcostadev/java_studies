package src.collections.tests;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();
        nomes.add("Chupa");
        nomes.add("tmj");
        nomes.remove("tmj");

        for(String n : nomes){
            System.out.println(n);
        }

        nomes.add("VAI FLAMENGO");
        System.out.println(nomes);

        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        System.out.println(nums);

        System.out.println(nomes.contains("Chupa"));
    }

}
