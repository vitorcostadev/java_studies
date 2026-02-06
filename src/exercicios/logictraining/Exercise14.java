package src.exercicios.logictraining;

import java.security.SecureRandom;

public class Exercise14 {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        int a = random.nextInt(99), b = random.nextInt(99);

        int temp = a;
        a = b;
        System.out.println("A: "+a+"\nB: "+b);
        b = temp;
        System.out.println("A: "+a+"\nB: "+b);
    }
}
