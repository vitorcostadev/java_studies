package src.exercicios.logictraining;
import java.util.Scanner;
/*
5 - Faça um algoritmo que leia o valor do salário mínimo e o valor do salário de um usuário,
calcule quantos salários mínimos esse usuário ganha e imprima na tela o resultado.
(Base para o Salário mínimo R$ 1.293,20).
 */
public class Exercise05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double salario = 0;
        final double SALARIO_MINIMO = 1293.20;

        do {
            System.out.println("Digite o valor do salario: "); salario = scan.nextDouble();
        }while(salario < 0); scan.close();

        int qtyMinSalario = 0;

        do{
            salario -= SALARIO_MINIMO; qtyMinSalario++;
        }while(salario >= SALARIO_MINIMO);

        if(qtyMinSalario > 0) System.out.println("O seu salario equivale a cerca de "+qtyMinSalario+" salários minimos.");
        else System.out.println("O seu salário é menor que o salario minimo atual.");
    }
}
