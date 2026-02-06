package src.strings.tests;

public class StringTest {
    public static void main(String[] args) {
        String name = "William"; // String constant pool
        String name2 = "William";
        name = name.concat(" Suane");
        System.out.println(name);
        System.out.println(name == name2);
    }
}
