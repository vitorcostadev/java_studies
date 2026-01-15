package src.exercicios.logictraining;

import java.security.SecureRandom;

/*
22 - Faça um algoritmo que calcule a quantidade de litros de combustível gastos em uma viagem,
sabendo que o carro faz 12km com um litro. Deve-se fornecer ao usuário o tempo que será gasto na viagem
a sua velocidade média, distância percorrida e a quantidade de litros utilizados para fazer a viagem.
 */
public class Exercise22 {
    static void main() {
        SecureRandom random = new SecureRandom();

        int tempo = random.nextInt(1,30);
        int velocidade = random.nextInt(90, 180);

        int distance = tempo * velocidade;
        int litrosUsado = distance / 12;

        System.out.println(
                "L/km: 12\nVelocidade media: "+
                        velocidade+"km/h\nTempo gasto: "+
                        tempo+"h\nDistancia percorrida: "+
                        distance+"km"+
                        "\nLitros usados: "+
                        litrosUsado+"L\n"+
                        "Estimativa de gasto em gasolina:\nR$"+(int)(litrosUsado*6.14)+" (comum)"+
                        "\nR$"+(int)(litrosUsado*6.34)+" (adtivada)");
    }
}
