package src.exercicios.sistema_seminarios;

public class Seminario {
    private String title;
    private Aluno[] alunos = null;
    private Local local = null;

    public Seminario(String title, Aluno[] alunos, Local local){
        this.title = title;
        this.alunos = alunos;
        this.local = local;

    }

    public Seminario(String title, Local local){
        this.title = title;
        this.local = local;

    }

    public Aluno[] getAlunos() {
        return alunos;
    }

    public Local getLocal() {
        return local;
    }

    public String getTitle() {
        return title;
    }

    public void setAlunos(Aluno... alunos) {
        this.alunos = alunos;
    }
    
    public void setLocal(Local local) {
        this.local = local;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void imprimirInfo()
    {
    
        System.out.println("Título do seminário: "+this.title);
        System.out.println("Local do seminário: "+this.local.getEndereco());
        
        if(this.alunos == null){
            System.out.println("Alunos: NENHUM"); return;
        }

        System.out.println("Alunos: ");
        for(Aluno aluno : this.alunos){
            System.out.println("- "+aluno.getNome());
        }
        System.out.println("----------------------------------------------");
    }
}
