package src.collections.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BinarySearchTest {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        Random random = new Random();

        for(int i = 0; i < 20; i++){
            nums.add(random.nextInt(i + ((i+1) * 2)));
        }
        Collections.sort(nums);
        System.out.println(nums);
        //(-(ponto de inserção) - 1)
        System.out.println(Collections.binarySearch(nums, 25));
    }
}
