package src.poo.abstract_class.classes;

public abstract class Funcionario extends Pessoa{
    protected String name;
    protected double salario;

    public Funcionario(String name, double salario){
        this.salario = salario;
        this.name = name;
        calcularBonus();
    }

    public abstract void calcularBonus();

}
