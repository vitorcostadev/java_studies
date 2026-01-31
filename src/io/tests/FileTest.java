package src.io.tests;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;

public class FileTest {
    void main(){
        File file = new File("C:\\Users\\yori0\\OneDrive\\Documentos\\Cjava\\files\\file.txt");
        try {
            if(file.exists()){
                boolean isDeleted = file.delete();
                System.out.println(isDeleted);
            }
            boolean isCreated = file.createNewFile();
            System.out.println(isCreated);

            System.out.println("File absolute path: "+ file.getAbsolutePath());
            System.out.println("Is file: "+file.isFile());
            System.out.println("Is directory: "+file.isDirectory());
            System.out.println("Is hidden archive: "+file.isHidden());
            System.out.println("Last modified: "+ Instant.ofEpochMilli(file.lastModified()).atZone(ZoneId.systemDefault()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
