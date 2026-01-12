package src.poo.modificador_final.classes;

public class Carro {
    private String name;
    public static final double SPEED_LIMIT;
    public final Comprador COMPRADOR = new Comprador();

    static {
        SPEED_LIMIT = 250;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
