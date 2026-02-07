package src.poo.heranca.classes;

public class Address {
    private String rua;
    private String cep;

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCep() {
        return cep;
    }

    public String getRua() {
        return rua;
    }

    /*public Address(String rua, String cep){
        this.rua = rua;
        this.cep = cep;
    }*/
}
