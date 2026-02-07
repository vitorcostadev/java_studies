package src.exercicios.logictraining;
import java.util.Scanner;
/*
2 - Faça um algoritmo para receber um número qualquer
e imprimir na tela se o número é par ou ímpar, positivo ou negativo.
 */
public class Exercise02 {
    public static void main(String[] args) {
        int value = 0;
        Scanner scan = new Scanner(System.in);

        do{
            System.out.println("Digite um valor: ");
            value = scan.nextInt();
        }while(value == 0);
        scan.close();

        if(value % 2 == 0) System.out.println(value + " é par!");
        else System.out.println(value + " é ímpar!");
    }


}
