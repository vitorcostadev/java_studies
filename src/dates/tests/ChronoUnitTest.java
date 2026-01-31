package src.dates.tests;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class ChronoUnitTest {
    static void main(String[] args) {
        LocalDateTime birthday = LocalDateTime.of(2005, Month.JUNE, 20, 0, 0 ,0);
        System.out.println(ChronoUnit.DAYS.between(birthday, LocalDateTime.now()));
        System.out.println(ChronoUnit.WEEKS.between(birthday, LocalDateTime.now()));
        System.out.println(ChronoUnit.MONTHS.between(birthday, LocalDateTime.now()));
        System.out.println(ChronoUnit.YEARS.between(birthday, LocalDateTime.now()));
    }
}
