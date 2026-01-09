package src.exercicios;

import java.util.Scanner;


public class ex03 {
    public static void main(String[] args) {
        /*
        Crie dois arrays do mesmo tamanho:
        um com nomes de produtos e outro com as quantidades em estoque (int).
        Peça ao usuário um produto e a quantidade que ele quer comprar.
        Se tiver estoque suficiente, desconte. Senão, avise que não tem.
        Repita até o usuário digitar “sair”.
        */

        String nomeDosProdutos[] = {"Arroz", "Feijao", "Batata", "Bolo"};
        int[] qtyInStock = {1,3,5,1};
        Scanner scan = new Scanner(System.in);

        String option = "";

        do{
            do{
                IO.print("Digite o nome do produto que deseja comprar: ");
                option=scan.next().strip().toLowerCase();

                if(option.length() == 0) System.out.println("O nome do produto não deve ficar vazio.");

            }while(option.length() == 0);

            if(!option.equals("sair")){
                for(int i = 0; i<nomeDosProdutos.length; i++){
                    if(option.equals(nomeDosProdutos[i].toLowerCase())){
                        if(qtyInStock[i] > 0){
                            IO.print("O produto "+option.toUpperCase()+" foi comprado com sucesso!\n");
                            qtyInStock[i] -= 1;
                        }else System.out.println("Não temos estoque para esse produto.");
                    }
                }
            }
        
        }while(!option.equals("sair"));

        scan.close();

    }
}
