package src.exercicios.logictraining;

import java.security.SecureRandom;

/*
17 - Faça um algoritmo que leia uma temperatura em Fahrenheit e
calcule a temperatura correspondente em grau Celsius. Imprima na tela as duas temperaturas.
 */
public class Exercise17 {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();

        int fah = random.nextInt(710) + 90;
        System.out.println("Temperatura em fahrenheit: "+fah+"°F");
        int celsius = (5 * (fah-32)/9);
        System.out.println("Temperatura convertida para celsius: "+celsius+"°C");
    }
}
