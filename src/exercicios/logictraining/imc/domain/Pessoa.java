package src.exercicios.logictraining.imc.domain;

public class Pessoa {
    private String name;
    private double peso;
    private Imc imc = null;

    public Pessoa(String name, double peso) {
        this.name = name;
        this.peso = peso;
    }

    public Imc calcularImc(){
        if (peso >= 40) return Imc.OBESIDADE_GRAU_III;
        else if (peso >= 35) return Imc.OBESIDADE_GRAU_II;
        else if (peso >= 30) return Imc.OBESIDADE_GRAU_I;
        else if (peso >= 25) return Imc.LEVEMENTE_ACIMA_DO_PESO;
        else if (peso >= 18.6) return Imc.PESO_IDEAL;
        else if (peso < 18.5) return Imc.ABAIXO_DO_PESO;

        return null;
    }


}
