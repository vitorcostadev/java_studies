package src.internal_classes.tests;

class Animal{
    public void walk(){
        System.out.println("Animal walking...");
    }
}

public class AnonymousClassesTest {
    public static void main(String[] args) {
        Animal animal = new Animal(){
            @Override
            public void walk() {
                System.out.println("Cachorro walking...");
            }
        };
        animal.walk();
    }
}
