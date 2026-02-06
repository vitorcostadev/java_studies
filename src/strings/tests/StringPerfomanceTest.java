package src.strings.tests;

public class StringPerfomanceTest {
    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        concatString(1000_0000);
        long fim = System.currentTimeMillis();

        System.out.println("Tempo: gasto: "+(fim - inicio) + "ms.");
    }

    private static void concatString(int size){
        StringBuilder template = new StringBuilder(size);

        for(int i = 0; i<size; i++){
            template.append(i);
        }
    }
}
