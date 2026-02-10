package src.internal_classes.tests;

public class OuterClassTest01 {
    private String name = "Ai Hoshino";

    void print(){
        final class LocalClass{
            public void printLocal(){
                System.out.println(name);
            }
        }

        LocalClass local = new LocalClass();
        local.printLocal();
    }
    public static void main(String[] args) {
        OuterClassTest01 outer = new OuterClassTest01();
        outer.print();
    }
}
