package src.poo.polimorfismo.domain;

public class Computador extends Produto{
    public static final double IMPOSTO = 0.21;
    public Computador(String name, double valor){
        super(name, valor);
    }

    @Override
    public double calcularImposto() {
        System.out.println("Calculando imposto do computador...");
        return this.valor * IMPOSTO;
    }

}
