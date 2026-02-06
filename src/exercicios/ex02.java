package src.exercicios;

import java.util.Scanner;


public class ex02 {
    public static void main(String[] args) {
        /*
        Leia uma matriz 3x4 representando vendas de 3 vendedores em 4 meses.
        Calcule: total de cada vendedor, total de cada mês e o vendedor com maior soma no ano.
        Use operadores, laços aninhados e condicionais. Nada de gambiarra manual.
        */

        int[][] vendas = new int[3][4];
        String[] vendedores = new String[3];
        Scanner scan = new Scanner(System.in);

        int i=0;

        do{
            System.out.printf("Digite o nome do %d vendedor(a): %n", i+1);
            vendedores[i++] = scan.next().trim().toUpperCase();
        }while(i<3);

        int[] totalVendas = new int[3];
        int maiorVendedor = 0;

        int cont = 0;
        for(int[] k : vendas){
            for(int x = 0; x<k.length; x++){
                System.out.printf("Digite o total em reais de vendas no mês %d do vendedor(a) %s: ", x+1, vendedores[cont]);
                k[x] = scan.nextInt();

                totalVendas[cont] += k[x];
            }
            cont++;

        }
        scan.close();

        System.out.println("\nTotal de vendas por vendedor no ano:");
        for(i=0; i<totalVendas.length; i++){
            System.out.printf("Vendedor(a) %s: R$ %d%n", vendedores[i], totalVendas[i]);

            if(totalVendas[i]>totalVendas[maiorVendedor]){
                maiorVendedor = i;
            }
        }

        System.out.println("\nTotal de vendas por mês:");
        for(int x=0; x<4; x++){
            int totalMes = 0;
            for(int y=0; y<3; y++){
                totalMes += vendas[y][x];
            }
            System.out.printf("Mês %d: R$ %d%n", x+1, totalMes);
        }

        System.out.println("Maior vendedor no ano: "+vendedores[maiorVendedor]);

    }
    
}
