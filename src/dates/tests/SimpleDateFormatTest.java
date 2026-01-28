package src.dates.tests;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest {
    static void main() {
        String pattern = "'Brasil' dd 'de' MMMM 'de' yyyy";
        SimpleDateFormat date = new SimpleDateFormat(pattern);
        System.out.println(date.format(new Date()));

    }
}
