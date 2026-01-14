package src.exercicios.logictraining;
import java.util.Scanner;
/*
1 - Faça um algoritmo que leia os valores de A, B, C e em seguida
imprima na tela a soma entre A e B é mostre se a soma é menor que C.
 */
public class Exercise01 {
    static void main() {
        int[] values = new int[3];
        Scanner scan = new Scanner(System.in);

        for(int i = 0; i<3; i++)
        {
            System.out.print("Digite o "+(i+1)+"° valor: ");
            values[i] = scan.nextInt();
        }

        int sumAB = values[0]+values[1];

        System.out.println("A soma do valor A + B é: "+sumAB);
        System.out.println(sumAB < values[2] ? "A soma de AB é menor do que C" : "A soma de AB é maior do que C.");
    }
}
