package src.exercicios.logictraining;

import java.security.SecureRandom;

/*

16 - Faça um algoritmo que leia três valores que representam os três lados de um triângulo e
 verifique se são válidos, determine se o triângulo é equilátero, isósceles ou escaleno.
 */
public class Exercise16 {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();

        int x = 10;
        int y = 10;
        int z = 20;

        System.out.println("X: "+x+"\nY: "+y+"\nz: "+z);
        if(x==y && y == z) System.out.println("Equilatero");
        else if(x == y || y == z) System.out.println("Isosceles");
        else System.out.println("Escaleno");
    }


}
