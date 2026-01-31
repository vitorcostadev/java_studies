package src.poo.heranca.classes;

public class Refrigerante extends Produto {
    private String sabor;

    @Override
    public void getName(){
        System.out.println(this.name);
    }
}
