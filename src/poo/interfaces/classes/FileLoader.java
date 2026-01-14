package src.poo.interfaces.classes;

public class FileLoader implements DateLoader, DataRemover{
    @Override
    public void load() {
        System.out.println("Loading data from a archive...");
    }

    @Override
    public void remove(){
        System.out.println("Removing data from a file...");
    }
}
