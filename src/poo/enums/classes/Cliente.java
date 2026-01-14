package src.poo.enums.classes;

public class Cliente {
    private String name;
    private TypeCliente typeCliente;

    public Cliente(String name, TypeCliente typeClient){
        this.name = name;
        this.typeCliente = typeClient;
    }

    @Override
    public String toString() {
        return this.typeCliente.toString();
    }

    public String getName() {
        return name;
    }

    public TypeCliente getTypeCliente() {
        return typeCliente;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTypeCliente(TypeCliente typeCliente) {
        this.typeCliente = typeCliente;
    }

   
}

