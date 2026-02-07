package src.collections.tests;

import src.collections.domain.Smartphone;

public class EqualsTest {
    public static void main(String[] args) {
        Smartphone phone = new Smartphone("1AFF", "Xiaomi");
        Smartphone phone2 = new Smartphone("1AFF", "Xiaomi");

        System.out.println(phone.hashCode());
    }
}
