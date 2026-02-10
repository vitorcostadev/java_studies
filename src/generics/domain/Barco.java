package src.generics.domain;

public class Barco implements Name{
    private String name;

    public Barco(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Barco{" +
                "name='" + name + '\'' +
                '}';
    }
}
