package src.exercicios;

import java.security.SecureRandom;

public class ex05 {
    public static void main(String[] args) {
        /*
        Crie uma matriz 5x5 preenchida automaticamente com números de 1 a 25.
        Depois, usando laços, calcule:
        a soma da diagonal principal, a soma da diagonal secundária,
        e quantos números são pares e quantos são ímpares.
        Se a soma das diagonais for igual, mostre “Simetria curiosa detectada”.
        */

        int[][] matrizQuadrada = new int[5][5];
        for(int i = 0; i<matrizQuadrada.length; i++){
            for(int j = 0; j<matrizQuadrada[i].length; j++){
                SecureRandom random = new SecureRandom();
                matrizQuadrada[i][j] = random.nextInt(900);
            }
        }

        int diagonalPrincipal = 0, diagonalSecundaria = 0, pares=0, impares=0;

        for(int i = 0; i<matrizQuadrada.length; i++){
            for(int j = 0; j<matrizQuadrada[i].length; j++){
                if(i == j){
                    diagonalPrincipal += matrizQuadrada[i][j];
                }else if(i-j == matrizQuadrada.length-1 - 2*j){
                    diagonalSecundaria += matrizQuadrada[i][j];
                }

                if(matrizQuadrada[i][j] % 2 == 0){
                    pares++;
                }else impares++;
            }
        }

        for(int i = 0; i<matrizQuadrada.length; i++){
            for(int j = 0; j<matrizQuadrada[i].length; j++){
                System.out.print(matrizQuadrada[i][j] + " ");
            }
            System.out.println("\n--------------------------------------------");
        }

        System.out.println("A soma da diagonal principal é: "+diagonalPrincipal);
        System.out.println("A soma da diagonal secundária é: "+diagonalSecundaria);

        if(diagonalPrincipal == diagonalSecundaria) System.out.println("Simetria curiosa detectada.");

        System.out.println("Quantidade de numeros pares: "+pares);
        System.out.println("Quantidade de numeros ímpares: "+impares);

        
    }
}
