package src.poo.abstract_class.classes;

public class Developer extends Funcionario{
    public Developer(String name, double salario) { super(name, salario); }

    @Override
    public String toString() {
        return "Developer{"+
                "'name': '"+this.name+"',"
                +"'salario': '"+this.salario+"'}";
    }

    @Override
    public void calcularBonus(){
        this.salario = this.salario + this.salario * 0.1;
    }

    @Override
    public void imprime(){
        System.out.println(this.toString());
    }
}
