package src.exercicios.logictraining.Exercise12;

public class Produto {
    private double valor;
    private int parcelas=0;

    public Produto(double valor, int parcelas) {
        this.valor = valor;
        this.parcelas = parcelas;
    }

    public Produto() {}

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }
}
