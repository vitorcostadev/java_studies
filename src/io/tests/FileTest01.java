package src.io.tests;

import java.io.File;
import java.io.IOException;

public class FileTest01 {
    public static void main(String[] args) {
        File directory = new File("files");
        boolean isCreatedDirectory = directory.mkdir();
        System.out.println(isCreatedDirectory);

        File directoryArchive = new File(directory, "file.txt");
        try {
            boolean isFileDirectoryArchiveCreated = directoryArchive.createNewFile();
            System.out.println(isFileDirectoryArchiveCreated);

            File fileRenamed = new File(directory, "file_renamed.txt");
            boolean renameTo = directoryArchive.renameTo(fileRenamed);
            System.out.println(renameTo);
            
            File fileRenamed2 = new File(directory, "file_asuna.txt");
            boolean isRenamed2 = directoryArchive.renameTo(fileRenamed2);
            System.out.println(isRenamed2);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
