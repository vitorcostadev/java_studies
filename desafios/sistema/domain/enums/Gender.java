package desafios.sistema.domain.enums;

public enum Gender {
    MALE(1, "Masculino"),
    FEMALE(2, "Feminino");

    private int id;
    private String name;

    Gender(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
