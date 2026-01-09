package src.poo.metodos.classes;

public class Funcionario {
    public String nome;
    public int idade;
    public int[] salario = new int[3];

    public void imprimirInfo(){
        System.out.println("Nome: "+this.nome);
        System.out.println("Idade: "+this.idade);
        System.out.println("Salario: " );
        for(int salario : this.salario) IO.print(salario + " | ");
        System.out.println("\nMedia Salarial: "+ mediaSalarial());
    }

    public double mediaSalarial(){
        double media = 0;

        for(int salario : this.salario) media += salario;

        return media / this.salario.length;
    }
}
