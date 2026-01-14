package src.poo.interfaces.classes;

public class DatabaseLoader implements DateLoader, DataRemover{
    @Override
    public void load(){
        System.out.println("Loading data from a database...");
    }

    @Override
    public void remove(){
        System.out.println("Removing data from a database...");
    }
}
