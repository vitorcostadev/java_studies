package src.dates.tests;

import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class LocalTimeTest {
    static void main() {
        LocalTime local = LocalTime.now();
        System.out.println(local.getHour());
        System.out.println(local.get(ChronoField.AMPM_OF_DAY));
        System.out.println(LocalTime.MIN);
    }
}
