package src.poo.metodos.classes;


public class Jogador {

    private String name;
    private Team team;

    public Jogador(String name) {this.name = name;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
    
    public void imprimir()
    {
        System.out.println(this.name);
        if(this.team != null){
            System.out.println(this.team.getName());
        }
    }
}
