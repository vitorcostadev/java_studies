package src.exercicios.logictraining.imc.domain;

public enum Imc {
    ABAIXO_DO_PESO(1, "Abaixo do Peso!"),
    PESO_IDEAL(2, "Peso Ideal!"),
    LEVEMENTE_ACIMA_DO_PESO(3, "Levemente Acima do Peso!"),
    OBESIDADE_GRAU_I(4, "Obesidade Grau I"),
    OBESIDADE_GRAU_II(5, "Obesidade Severa"),
    OBESIDADE_GRAU_III(6, "Obesidade Mórbida");

    private final int imcIndice;
    private final String imcState;

    Imc(int Indice, String State){
        this.imcIndice = Indice;
        this.imcState = State;
    }

    @Override
    public String toString() {
        return "Imc{" +
                "imcIndice=" + imcIndice +
                ", imcState='" + imcState + '\'' +
                '}';
    }
}
