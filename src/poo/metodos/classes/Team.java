package src.poo.metodos.classes;

public class Team {
    private String name;
    private Jogador[] jogadores;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Jogador[] getJogadores() {
        return jogadores;
    }

    public void imprimir()
    {
        System.out.println(this.name);
        if(this.jogadores != null){
            for(Jogador player : this.jogadores) System.out.println(player.getName() + " ");
        }
    }
    public void setJogadores(Jogador... jogadores) {
        if(jogadores != null){
            this.jogadores = new Jogador[11];

            for(int i = 0; i<jogadores.length && i < 12; i++){
                this.jogadores[i] = jogadores[i];
                System.out.println("Added the player "+jogadores[i].getName()+" to the list.");
            }
        }
    }

    public Team(String name) { this.name = name; }
    public Team(String name, Jogador[] players)
    {
        this.jogadores = players;
        this.name = name;
    }
}
