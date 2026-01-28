package src.exceptions.tests.errors;

public class StackOverflowTest {
    static void main() {
        recursividade();
    }

    public static void recursividade(){
        recursividade();
    }
}
