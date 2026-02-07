package src.poo.abstract_class.classes;

public class Gerente extends Funcionario{
    public Gerente(String name, double salario){
        super(name, salario);
    }

    @Override
    public String toString() {
        return "Gerente{"+
                "'name': '"+this.name+"',"
                +"'salario': '"+this.salario+"'}";
    }

    @Override
    public void calcularBonus(){
        this.salario = this.salario + this.salario * 0.05;
    }
    
    @Override
    public void imprime(){
        System.out.println(this.toString());
    }
}
