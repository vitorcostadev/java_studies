package src.dates.tests;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DateLocaleTest {
    public static void main(String[] args) {
        // pt-BR
        Locale localeItaly = new Locale("it", "IT");
        Locale localeSwi = new Locale("it", "CH");
        Locale localeIndia = new Locale("hi", "IN");
        Calendar calendar = Calendar.getInstance();

        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, localeItaly);
        DateFormat df2 = DateFormat.getDateInstance(DateFormat.FULL, localeSwi);
        DateFormat df3 = DateFormat.getDateInstance(DateFormat.FULL, localeIndia);
        System.out.println("Italy: "+ df.format(calendar.getTime()));
        System.out.println("Switzerland: "+ df2.format(calendar.getTime()));
        System.out.println("India: "+ df3.format(calendar.getTime()));
         
    }
}
