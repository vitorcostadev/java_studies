package src.poo.metodos.tests;

import src.poo.metodos.classes.Jogador;
import src.poo.metodos.classes.Team;

public class JogadorTest01 {
    public static void main(String[] args) {
        Jogador player = new Jogador("Pelé");
        Team team = new Team("Seleção Brasileira");

        player.setTeam(team);
        team.setJogadores(player);
    }
}
