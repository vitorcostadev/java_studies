package desafios.sistemaDeCadastroDePet.domain;

public enum GenrePet {
    MALE(1, "Masculino"),
    FEMALE(2, "Feminino");

    private int id;
    private String attrName;

    private GenrePet(int id, String attrName){
        this.id = id;
        this.attrName = attrName;
    }

    public String getAttrName() {
        return attrName;
    }

    public int getId() {
        return id;
    }
}
