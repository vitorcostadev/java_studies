package src.dates.tests;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjustersTest {
    static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now);

        now = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        System.out.println(now);

        now = LocalDate.now().with(TemporalAdjusters.previous(DayOfWeek.SATURDAY));
        System.out.println(now);
    }
}
