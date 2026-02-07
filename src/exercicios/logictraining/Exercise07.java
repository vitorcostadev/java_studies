package src.exercicios.logictraining;

/*
7 - Faça um algoritmo que leia dois valores booleanos (lógicos) e determine se ambos são VERDADEIRO ou FALSO.
 */
public class Exercise07 {
    public static void main(String[] args) {
        boolean first = true,
                second = true;

        if(!second && !first) System.out.println("FALSOS");
        else if(second != first) System.out.println("DIFERENTES");
        else System.out.println("VERDADEIROS");
    }
}
