package src.exercicios;
import java.util.Scanner;
/*
4 - Faça um algoritmo que receba um número inteiro e
imprima na tela o seu antecessor e o seu sucessor.
 */
public class Exercise04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int value = 0;

        do{
            System.out.println("Digite um valor: ");
            value = scan.nextInt();

        }while(value < 0); scan.close();

        System.out.println("Antecessor: "+(value-1)+"\nSucessor: "+(value+1));
    }


}
