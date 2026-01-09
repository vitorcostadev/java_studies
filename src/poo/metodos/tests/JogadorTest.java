package src.poo.metodos.tests;

import src.poo.metodos.classes.Jogador;
import src.poo.metodos.classes.Team;


public class JogadorTest
{
    public static void main(String[] args) {
        Jogador player = new Jogador("Pelé");
        //Jogador player2 = new Jogador("Romário");
        //Jogador player3 = new Jogador("Messi");
        Team team_ = new Team("Flamego");

        player.setTeam(team_);
        player.imprimir();
    }
}