package src.dates.tests;

import src.collections.domain.Severity;
import src.collections.exercises.LogEntry;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

public class InstantDateTest {
    public static void main(String[] args) {
        Instant now = Instant.now();

        LogEntry log = new LogEntry("001", "Tmj", Instant.ofEpochMilli(200L), Severity.ERROR);
        LogEntry log2 = new LogEntry("001", "Tmj", Instant.ofEpochMilli(100L), Severity.ERROR);

        if(log.equals(log2)){
            System.out.println(log.hashCode());
            System.out.println(log2.hashCode());
        }

    }
}
