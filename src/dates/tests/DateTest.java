package src.dates.tests;

import java.util.Date;

public class DateTest {
    static void main() {
        Date date = new Date();
        date.setTime(date.getTime()+3_600_000);
        System.out.println(date);
    }

}
