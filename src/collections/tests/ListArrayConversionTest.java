package src.collections.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ListArrayConversionTest {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        generateArray(nums, 20);

        Integer[] integerstoArray = nums.toArray(new Integer[0]);
        System.out.println(Arrays.toString(integerstoArray));

        Integer[] numsArr = new Integer[20];
        generateArray(numsArr, 20);
        System.out.println(Arrays.toString(numsArr));
    }

    public static void generateArray(List<Integer> arr, int quantity){
        Random random = new Random();
        for(int i  = 0; i<quantity; i++){
            arr.add(random.nextInt(i + ((i+1) * 2)));
        }
    }

    public static void generateArray(Integer[] arr, int quantity){
        Random random = new Random();
        for(int i  = 0; i<quantity; i++){
            arr[i] = random.nextInt(i + ((i+1) * 2));
        }
    }
}
