package src.exercicios.logictraining;

import java.security.SecureRandom;

/*
19 - Faça um algoritmo que imprima na tela a tabuada de 1 até 10.
 */
public class Exercise19 {
    static void main() {
        SecureRandom random = new SecureRandom();

        int tab = random.nextInt(1, 20);

        System.out.println("Tabuada do 1 até "+tab);

        for(int i = 0; i<tab; i++){
            for(int j = 0; j<10; j++){
                System.out.println((i+1) + " * "+(j+1)+" : "+(i+1) * (j+1));
            }
            System.out.println("=============================");
        }
    }
}
