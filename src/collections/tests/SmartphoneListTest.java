package src.collections.tests;

import src.collections.domain.Smartphone;

import java.util.ArrayList;
import java.util.List;

public class SmartphoneListTest {
    public static void main(String[] args) {
        Smartphone phone = new Smartphone("1AFF", "Xiaomi");
        Smartphone phone2 = new Smartphone("312ddd", "Xiaomi");
        Smartphone phone3 = new Smartphone("312dss2d", "Poco");
        List<Smartphone> smartphones = new ArrayList<>(6);
        smartphones.add(phone);
        smartphones.add(phone2);
        smartphones.add(phone3);

        for (Smartphone smartphone : smartphones) {
            System.out.println(smartphone.toString());
        }
        if (smartphones.contains(phone3)) {
            System.out.println(phone3);
        }
    }
}
