package src.exercicios.sistema_seminarios;

public class Aluno {
    private String nome;
    private int idade;
    private Seminario seminario = null;


    public Aluno(String nome, int idade, Seminario seminario){
        this.nome = nome;
        this.idade = idade;
        this.seminario = seminario;
    }
    

    public Aluno(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }


    public int getIdade() {
        return idade;
    }

    public String getNome() {
        return nome;
    }

    public Seminario getSeminario() {
        return seminario;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSeminario(Seminario seminario) {
        if(this.seminario != null){
            System.out.printf("O aluno %s já está em um seminário e não pode participar de mais de um.%n", this.nome);
            return;
        }

        this.seminario = seminario;
    }

    public void imprimirInfo(){
        System.out.println("Nome do aluno: "+this.nome);
        System.out.println("Idade do aluno: "+this.idade);
        if(this.seminario != null) System.out.println("Seminario: "+this.seminario.getTitle());
        System.out.println("----------------------------------------------");


    }
}
