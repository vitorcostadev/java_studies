package src.poo.interfaces.classes;

public interface DateLoader {
    public static final int MAX_DATA_SIZE = 10;

    void load();
    default void checkPermission(){
        System.out.println("Verificando a disponibilidade...");
    }

    public static void retrieveMaxDataSize(){
        System.out.println("Dentro do retrieveMaxDataSize");
    }
}
