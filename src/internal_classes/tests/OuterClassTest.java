package src.internal_classes.tests;

public class OuterClassTest {
    private String name = "Asuna";

    // Nested
    class Inner{
        public void printOuterClassAttr(){
            System.out.println(name);
        }
    }
    public static void main(String[] args) {
        OuterClassTest outerClass = new OuterClassTest();
        Inner inner = outerClass.new Inner();
        inner.printOuterClassAttr();
    }
}
