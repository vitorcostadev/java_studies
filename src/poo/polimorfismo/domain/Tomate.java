package src.poo.polimorfismo.domain;

public class Tomate extends Produto{
    public static final double IMPOSTO = 0.06;
    private String dataDeValidade;

    public Tomate(String name, double valor){
        super(name, valor);
    }

    @Override
    public double calcularImposto() {
        System.out.println("Calculando imposto do Tomate...");
        return this.valor * IMPOSTO;
    }

    public String getDataDeValidade() {
        return dataDeValidade;
    }

    public void setDataDeValidade(String dataDeValidade) {
        this.dataDeValidade = dataDeValidade;
    }
}
