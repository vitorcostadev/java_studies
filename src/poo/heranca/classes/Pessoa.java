package src.poo.heranca.classes;

public class Pessoa {
    protected String name;
    protected String cpf;
    protected Address address;

    static {
        System.out.println("Dentro do bloco de inicialização estático de Pessoa");
    }

    {
        System.out.println("Dentro do bloco de inicialização de Pessoa");
    }
    public Pessoa(String name) { this.name = name; System.out.println("Dentro do construtor de Pessoa");}

    public void imprimirInfo(){
        System.out.println("Nome: "+this.name);
        System.out.println("CPF: "+this.cpf);
        System.out.println("Endereço: "+this.address.getRua());
    }

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
