package src.internal_classes.tests;

public class OuterClassTest03 {
    private String name;
    static class Nested {
        void print(){
            System.out.println(new OuterClassTest03().name);
        }
    }
    public static void main(String[] args) {
        Nested nested = new Nested();
        nested.print();
    }
}
