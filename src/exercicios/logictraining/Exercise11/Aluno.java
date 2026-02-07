package src.exercicios.logictraining.Exercise11;

public class Aluno {
    private String name;
    private int[] notas = null;
    private boolean isAproved=false;

    public Aluno(String name, int[] notas) {
        this.name = name;
        this.notas = notas;
    }

    public double mediaNotas(){

        double media = 0;
        if(notas != null){
            for(int nota : notas){
                media += nota;
            }

            return media / notas.length;
        }

        return 0;
    }

    public void relatory(){
        double media = this.mediaNotas();

        if(media >= 7) isAproved = true;

        System.out.println(
                "Nome " + this.name +
                        "\nMedia Final:  " + media +
                        "\nStatus: " + (isAproved ? "Aprovado(a)" : "Reprovado(a)")
        );
    }
}
