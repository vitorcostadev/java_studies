package src.poo.interfaces.tests;

import src.poo.interfaces.classes.DatabaseLoader;
import src.poo.interfaces.classes.DateLoader;
import src.poo.interfaces.classes.FileLoader;

public class DataLoaderTest {
    public static void main(String[] args) {
        DatabaseLoader database = new DatabaseLoader();
        FileLoader file = new FileLoader();

        database.load();
        file.load();

        database.remove();
        file.remove();

        database.checkPermission();

        DateLoader.retrieveMaxDataSize();
    }
    

}
