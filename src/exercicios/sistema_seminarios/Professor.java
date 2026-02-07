package src.exercicios.sistema_seminarios;

public class Professor {
    private String nome;
    private String especialidade;
    private Seminario[] seminarios = null;


    public Professor(String nome, String especialidade, Seminario[] seminario){
        this.nome = nome;
        this.especialidade = especialidade;
        this.seminarios = seminario;
    }

    public Professor(String nome, String especialidade){
        this.nome = nome;
        this.especialidade = especialidade;
    }


    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSeminarios(Seminario... seminarios) {
        this.seminarios = seminarios;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getNome() {
        return nome;
    }

    public Seminario[] getSeminarios() {
        return seminarios;
    }

    public void imprimirInfo(){
        System.out.println("Nome do professor: "+this.nome);
        System.out.println("Especialidade do professor: "+this.especialidade);
        if(this.seminarios != null){
            for(Seminario seminario : this.seminarios)
            {
                System.out.println("- "+seminario.getTitle());
            }
        }

        System.out.println("----------------------------------------------");
    }
}
