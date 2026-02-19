package desafios.sistema.domain.enums;

public enum Type {
    CAT(1, "Gato"),
    DOG(2, "Cachorro");

    private int id;
    private String name;

    Type(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
