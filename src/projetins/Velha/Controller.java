package src.projetins.Velha;

public class Controller {
    private Itens[] choose = new Itens[2];
    private String[] players = new String[2];

    public Controller(String[] players, Itens[] choose){
        this.players = players;
        this.choose = choose;
    }

    public void processChoose(){
        boolean effective = getEffective(choose[0], choose[1]);

        System.out.println("--------------------------------------------------");
        if (effective==true){
            System.out.println("O jogador "+players[0]+" ganhou esta rodada!");
            System.out.println("O jogador "+players[1]+" perdeu nesta rodada!");
        }else{
            System.out.println("O jogador "+players[1]+" ganhou esta rodada!");
            System.out.println("O jogador "+players[0]+" perdeu nesta rodada!");
        }
        System.out.println("--------------------------------------------------");

    }

    private boolean getEffective(Itens move, Itens target){
        
        if(move == Itens.PAPEL && target != Itens.TESOURA) return true;
        else if(move == Itens.TESOURA && target != Itens.PEDRA) return true;
        else if(move == Itens.PEDRA && target != Itens.PAPEL) return true;

        return false;
    }
    
}
