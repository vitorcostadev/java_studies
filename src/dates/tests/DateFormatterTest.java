package src.dates.tests;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatterTest {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        String s1 = date.format(DateTimeFormatter.ISO_DATE);
        System.out.println(s1.replace("-", "/"));

        LocalDate parse1 = LocalDate.parse(s1, DateTimeFormatter.ISO_DATE);
        System.out.println(parse1);

        LocalDateTime now = LocalDateTime.now();
        String s2 = now.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println(s2);

        LocalDateTime parse2 = LocalDateTime.parse(s2, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println(parse2);

        DateTimeFormatter formatterBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String br = LocalDate.now().format(formatterBR);
        System.out.println(br);
    }
}
