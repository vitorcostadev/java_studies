package src.nio.tests;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest02 {
    public static void main(String[] args) throws IOException{
        Path path = Paths.get("files");

        if(Files.notExists(path)){
            Path pathDirectory = Files.createDirectory(path);
            System.out.println(pathDirectory);
        }

        Path subPathDirectory = Paths.get("files/anime/aihoshino");
        Path subSubPathDirectory = Files.createDirectories(subPathDirectory);
        System.out.println(subSubPathDirectory);
        
        Path filePathDirectory = Paths.get(subSubPathDirectory.toString(), "i_love_you_aihoshino.txt");

        if(Files.notExists(filePathDirectory)){
            Path filePath = Files.createFile(filePathDirectory);
            System.out.println(filePath);
        }
    }
    
}
