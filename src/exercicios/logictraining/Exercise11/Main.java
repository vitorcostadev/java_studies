package src.exercicios.logictraining.Exercise11;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name;
        int[] notas;

        int qty=0;
        do{
            System.out.println("Quantas notas deseja cadastrar por aluno? ");
            qty=scan.nextInt();
        }while(qty < 0);

        notas = new int[qty];

        for(int i  = 0; i < qty; i++){
            System.out.println("Digite a "+(i+1)+"° nota: ");
            notas[i] = scan.nextInt();
        }

        do{
            System.out.println("Por ultimo, digite o nome do aluno(a): ");
            scan.skip("\\R");
            name=scan.nextLine();

            if(name.isEmpty()) System.out.println("O nome não pode ficar vazio.");
        }while(name.isEmpty());

        Aluno aluno = new Aluno(name, notas);
        aluno.relatory();
    }
}
