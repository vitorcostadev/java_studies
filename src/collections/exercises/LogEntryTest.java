package src.collections.exercises;

import org.jetbrains.annotations.NotNull;
import src.collections.domain.Severity;

import java.time.Instant;
import java.util.*;

class SeverityComparator implements Comparator<LogEntry>{
    @Override
    public int compare(LogEntry o1, LogEntry o2) {
        return Integer.compare(
                o1.getSeverity().getId(),
                o2.getSeverity().getId()
        );
    }
}
public class LogEntryTest {
    public static void main(String[] args) {
        List<LogEntry> entry = new ArrayList<>();
        generateListEntry(10, entry);
        entry.sort(new SeverityComparator());
        entry.forEach(System.out::println);

    }

    public static @NotNull String generateRandomName(@NotNull String args){
        Random random = new Random();
        return args.substring(random.nextInt(args.length()));
    }

    public static @NotNull String generateRandomName(){
        String args = "abcdefghijklmnopqrstuvwxyz1234567890";
        return generateRandomName(args);
    }


    public static void generateListEntry(int quantity, List<LogEntry> entry){
        if(quantity > 0){
            Random random = new Random();

            for (int i = 0; i < quantity; i++) {

                int nextInt = random.nextInt(20);
                Severity severity =
                        (nextInt % 2 == 0 && nextInt % 3 != 0)
                                ? Severity.ERROR
                                : (nextInt % 3 == 0 && nextInt % 2 != 0)
                                ? Severity.INFO
                                : Severity.WARN;

                entry.add(new LogEntry(
                        generateRandomName("1001abcde"),
                        generateRandomName(),
                        Instant.ofEpochMilli(random.nextInt(999)),
                        severity
                ));
            }
        }


    }
}
