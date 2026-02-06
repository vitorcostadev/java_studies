package src.exercicios.logictraining;
import java.util.Scanner;

/*
3 - Faça um algoritmo que leia dois valores inteiros A e B, se os valores de A e B forem iguais,
deverá somar os dois valores, caso contrário devera multiplicar A por B.
Ao final de qualquer um dos cálculos deve-se atribuir o resultado a uma variável C e
imprimir seu valor na tela.
 */
public class Exercise03 {
    public static void main(String[] args) {
        int[] values = new int[2];
        Scanner scan = new Scanner(System.in);
        int C = 0;

        for(int i = 0; i<2; i++){
            do {
                System.out.print("Digite o " + (i + 1) + "° valor: ");
                values[i] = scan.nextInt();
            }while(values[i] < 0);
        }
        scan.close();

        C = values[0] == values[1] ? values[0] + values[1] : values[0] * values[1];

        System.out.println("A: "+values[0]+"\nB: "+values[1]+"\nC: "+C);
    }


}
