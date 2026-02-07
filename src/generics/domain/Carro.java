package src.generics.domain;

public class Carro {
    private String name;

    @Override
    public String toString() {
        return "Carro{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public Carro(String name) {
        this.name = name;
    }
}
