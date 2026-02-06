package src.exercicios.logictraining;
import java.util.Scanner;

/*
8 - Faça um algoritmo que leia três valores inteiros diferentes e
imprima na tela os valores em ordem decrescente.
 */
public class Exercise08 {
    public static void main(String[] args) {
        int[] values = new int[3];
        Scanner scan = new Scanner(System.in);
        int i = 0;


        do{
            System.out.println("Digite um valor: "); values[i] = scan.nextInt();
            if(i > 0 && values[i-1] == values[i]){
                System.out.println("O valor inserido anteriormente é igual ao atual.");
            } else i++;
        }while(i < 3); scan.close();

        for(int ii = 0; ii < values.length / 2; ii++){
            int j = values.length - 1 - ii;

            if(values[j] > values[ii]){
                int temp = values[j];

                values[j] = values[ii];
                values[ii] = temp;
            }
        }

        for(int k : values) System.out.println(k);

    }
}
