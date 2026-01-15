package src.exercicios.logictraining;
import java.util.Scanner;


/*
 13 - Faça algoritmo que leia o nome e a idade de uma pessoa
 e imprima na tela o nome da pessoa e se ela é maior ou menor de idade.
 */
public class Exercise13 {
    static void main() {
        String name;
        int idade=0;
        Scanner scan = new Scanner(System.in);


        do{
            System.out.println("Digite seu nome: ");
            name = scan.nextLine();
        }while(name.isEmpty());

        do{
            System.out.println("Digite sua idade: ");
            idade = scan.nextInt();
        }while(idade < 0);

        System.out.println(name + " você é " + (idade > 17 ? "maior de idade." : "menor de idade."));
        scan.close();
    }
}
