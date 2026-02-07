package src.poo.heranca.classes;

public class Funcionario extends Pessoa{
    private double salario;

    static {
        System.out.println("Dentro do bloco de inicialização estático de Funcionario");
    }

    {
        System.out.println("Dentro do bloco de inicialização de Funcionario");
    }

    public Funcionario(String name, double salario){
        super(name);
        System.out.println("Dentro do construtor de funcionario.");
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void imprimirInfo(){
        super.imprimirInfo();
        System.out.println("Salário: "+this.salario);
    }

    public void RelatorioPayment(){
        System.out.println("Eu recebi o pagamento do usuário "+this.name+" no valor de R$ "+this.salario+".");
    }

}