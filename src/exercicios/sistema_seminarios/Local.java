package src.exercicios.sistema_seminarios;

public class Local {
    private String endereco;


    public Local(String endereco) { this.endereco = endereco; }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void imprimirInfo(){
        System.out.println("Endereço do local: "+this.endereco);
        System.out.println("----------------------------------------------");
    }

    
}
