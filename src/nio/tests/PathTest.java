package src.nio.tests;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {
    public static void main(String[] args) {
        Path path = Paths.get("files\\file.txt");
        System.out.println(path.getFileName());

    }
    
}
