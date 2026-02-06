package src.exceptions.tests.runtime;

public class RuntimeExceptionTest02 {
    public static void main(String[] args) {
        divide(1,0);
    }

    /**
     *
     * @param a divisor
     * @param b dividendo
     * @return o valor da divisão de a com b (int).
     * @throws IllegalArgumentException caso o parametro b seja zero.
     */
    private static int divide(int a, int b) throws IllegalArgumentException{
        if(b == 0){
            throw new IllegalArgumentException("O denominador não pode ser zero.");
        }
        return a/b;

    }
}
