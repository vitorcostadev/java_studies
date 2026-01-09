package src.poo.heranca.classes;

public class Pessoa {
    private String name;
    private String cpf;
    private Address address;

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    /*public Pessoa(String name, String cpf, Address address){
        this.name = name;
        this.cpf = cpf;
        this.address = address;
    }*/
}
