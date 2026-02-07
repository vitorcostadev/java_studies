package src.projetins.Velha;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        String[] players = new String[2];
        Itens[] itens = new Itens[2];
        short rodadas = 0;
        Scanner scan = new Scanner(System.in);


        do{
            System.out.print("Digite a quantidade de rodadas (max. 20): ");
            rodadas = scan.nextShort();

        }while(rodadas > 20);
        
        short i=0;
        do{
            System.out.print("Digite o nome do "+(i+1)+"° jogador(a): ");
            players[i] = scan.next();
            i++;
        }while(i < 2);

        short choose;
        i = 0;
        System.out.println("Começa o jogo, faça seus movimentos!");
        for(int rod = 0; rod<rodadas; rod++){
            do{
                do{
                    System.out.print("Jogador(a) "+players[i]+" digite sua escolha: \n");
                    System.out.println("[1] : PEDRA");
                    System.out.println("[2] : PAPEL");
                    System.out.print("[3] : TESOURA\n: ");
                    choose=scan.nextShort();

                    if(choose == 1) itens[i] = Itens.PEDRA;
                    if(choose == 2) itens[i] = Itens.PAPEL;
                    if(choose == 3) itens[i] = Itens.TESOURA;

                }while(choose < 1 || choose > 3);
                i++;
            }while(i<2);

            Controller controller = new Controller(players, itens);
            controller.processChoose();
            i = 0;
        }

        scan.close();
    }

    
}
