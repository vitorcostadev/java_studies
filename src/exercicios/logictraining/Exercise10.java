package src.exercicios.logictraining;

/*
 10 - Faça um algoritmo que leia três notas obtidas por um aluno, e imprima na tela a média das notas.
 */
public class Exercise10 {
    public static void main(String[] args) {
        int[] notas = new int[]{10,2,10};

        int x = 0;
        for(int k : notas){
            x += k;
        }
        System.out.println(notas.length > 0 ? x/notas.length : 0);
    }
}
