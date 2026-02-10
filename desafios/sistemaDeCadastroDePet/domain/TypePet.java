package desafios.sistemaDeCadastroDePet.domain;

public enum TypePet {
    DOG(1, "Cachorro"),
    CAT(2, "Gato");

    private int id; 
    private String attrName;

    TypePet(int id, String attrName){
        this.id = id;
        this.attrName = attrName;
    }

    public String getAttrName() {
        return attrName;
    }
}
