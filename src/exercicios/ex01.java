package src.exercicios;

import java.util.Scanner;

public class ex01 {
    public static void main(String[] args) {
        /*
        Crie um programa que leia as notas de N alunos (N informado pelo usuário).
        Guarde as notas em um array.
        Use laço para: média geral, maior nota, menor nota e quantidade de aprovados (nota ≥ 6).
        No fim, exiba tudo. Se a média geral for menor que 5, mostre a mensagem: “Desempenho ruim, precisa melhorar” — senão, “Turma ok”.
        */

        int qtyAlunos = 0;
        Scanner scan = new Scanner(System.in);

        do{
            System.out.print("Digite a quantidade de alunos: ");
            qtyAlunos=scan.nextInt();

            if(qtyAlunos <= 0){
                System.out.println("A quantidade de alunos deve ser maior do que zero.");
            }
        }while(qtyAlunos <= 0);
        
        String[] nomes = new String[qtyAlunos];
        double[][] notas = new double[qtyAlunos][3];
        final int mediaDeCorte = 6;

        for(int i = 0; i<qtyAlunos; i++){
            System.out.printf("Digite o nome do %d aluno(a): ", i+1);
            nomes[i] = scan.next().trim();
            for(int k = 0; k<3; k++){
                System.out.printf("Digite a %d° nota do aluno %s: ", k+1, nomes[i]);
                notas[i][k] = scan.nextDouble();
            }
        }
        scan.close();

        double mediaTurma = 0;
        double[] mediaAlunos = new double[qtyAlunos];

        System.out.printf("Relação das notas dos %d alunos registrados: %n", qtyAlunos);
        for(int i = 0; i<qtyAlunos; i++){
            for(int j = 0; j<notas[i].length; j++){
                mediaAlunos[i] += notas[i][j];
                mediaTurma += notas[i][j];
            }
        }

        for(String nome : nomes){
            for(int i = 0; i<qtyAlunos; i++){
                if(nome.equals(nomes[i])){
                    mediaAlunos[i] /= notas[i].length;
                    System.out.printf("Aluno(a): %s - Média: %.2f%n", nome, mediaAlunos[i]);
                    if(mediaAlunos[i] < mediaDeCorte){
                        System.out.println("Aluno Reprovado.");
                    }else System.out.println("Aluno aprovado.");
                }
            }
        }

        if(mediaTurma/ (qtyAlunos * 3) < 5){
            System.out.println("Desempenho ruim, precisa melhorar");
        } else {
            System.out.println("Turma ok");
        }

    }
    
}
