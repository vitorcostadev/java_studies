package src.collections.tests;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<String> stringQueue = new PriorityQueue<>();
        stringQueue.add("D");
        stringQueue.add("C");
        stringQueue.add("B");
        stringQueue.add("A");
        stringQueue.add("S");

        while(!stringQueue.isEmpty()){
            System.out.println(stringQueue.poll());
        }
    }
}
