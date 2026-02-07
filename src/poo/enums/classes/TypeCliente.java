package src.poo.enums.classes;

public enum TypeCliente {
    PESSOA_FISICA(1, "Pessoa Física"),
    PESSOA_JURIDICA(2, "Pessoa Jurídica");

    private int id;
    private String typeClient;

    private TypeCliente(int id, String typeClient){
        this.id = id;
        this.typeClient = typeClient;
    }

    public static TypeCliente getRelatorioByName(String typeClient){
        for( TypeCliente type : values()){
            if(type.getTypeClient().equals(typeClient)){
                return type;
            }
        }

        return null;
    }
    public String getTypeClient() {
        return typeClient;
    }

    public int getId() {
        return id;
    }

    @Override 
    public String toString(){
        return "typeClient: "+this.typeClient+"\nID: "+this.id;
    }
}
