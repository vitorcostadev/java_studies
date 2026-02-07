package src.repetitions;

import java.util.Scanner;

public class exercicio_break {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double valorCarro = 0, valorParcela = 0;
        final int parcelaCond = 1000;
        int i = 1;

        System.out.println("Digite o valor do carro: ");
        valorCarro=scan.nextDouble();
        scan.close();
        
        do{
            valorParcela = (valorCarro / i++);
        }while(valorParcela >= parcelaCond);

        System.out.printf("O valor do carro é de: %f reais.\n", valorCarro);
        System.out.printf("Voce pode parcelar em no máximo, %dx vezes, pagando %f cada.", i, valorParcela);
    }

    
    
}
