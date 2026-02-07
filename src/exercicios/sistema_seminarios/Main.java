package src.exercicios.sistema_seminarios;

public class Main {
    public static void main(String[] args) {
        Local local = new Local("Rua Valdemar Rufino da Silva");
        Seminario seminario = new Seminario("La Casa de Papel", local);
        Aluno aluno = new Aluno("Vitor Costa", 20);
        Professor professor = new Professor("Fernanda Costa", "Algoritimos");

        aluno.setSeminario(seminario);
        professor.setSeminarios(seminario);
        seminario.setAlunos(aluno);

        local.imprimirInfo();
        seminario.imprimirInfo();
        aluno.imprimirInfo();
        professor.imprimirInfo();
    }
}
