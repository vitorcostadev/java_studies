package src.dates.tests;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest {
    static void main() {
        Calendar c = Calendar.getInstance();
        Date date = c.getTime();
        System.out.println(date);

        if(c.getFirstDayOfWeek() == Calendar.SUNDAY){
            System.out.println("Domingao porra!");
        }

        System.out.println(c.get(Calendar.DAY_OF_MONTH));
        System.out.println(c.get(Calendar.DAY_OF_YEAR));
        System.out.println(c.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        System.out.println(c.get(Calendar.HOUR_OF_DAY));
    }
}
