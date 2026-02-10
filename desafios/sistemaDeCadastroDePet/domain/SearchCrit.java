package desafios.sistemaDeCadastroDePet.domain;

public enum SearchCrit {
    NAME(1, "Nome"),
    ADDRESS(2, "Endereço"),
    SEX(3, "Genêro"),
    AGE(4, "Idade"),
    SIZE(5, "Peso"),
    SPECIE(6, "Espécie");

    private int id;
    private String attName;

    private SearchCrit(int id, String attrname){
        this.id = id;
        this.attName = attrname;
    }
}
