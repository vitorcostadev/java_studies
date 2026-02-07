package src.poo.polimorfismo.domain;

public class Televisao extends Produto{
    public static final double IMPOSTO = 0.21;

    public Televisao(String name, double valor) {
        super(name, valor);
    }

    @Override
    public double calcularImposto() {
        System.out.println("Calculando imposto da Televisão");
        return this.valor * IMPOSTO;
    }
}
