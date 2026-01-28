package src.dates.tests;

import java.time.Instant;
import java.time.LocalDateTime;

public class InstantDateTest {
    static void main() {
        Instant now = Instant.now();
        System.out.println(now);
        System.out.println(LocalDateTime.now());
    }
}
