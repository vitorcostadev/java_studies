package src.exceptions.tests.errors;

public class StackOverflowTest {
    public static void main(String[] args) {
        recursividade();
    }

    public static void recursividade(){
        recursividade();
    }
}
