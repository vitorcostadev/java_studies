package src.poo.polimorfismo.domain;

public abstract class Produto implements Taxavel{
    protected String name;
    protected double valor;

    public Produto(String name, double valor)
    {
        this.valor = valor;
        this.name = name;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
