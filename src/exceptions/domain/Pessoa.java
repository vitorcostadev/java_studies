package src.exceptions.domain;

import src.exceptions.exception.domain.InvalidLoginException;
import java.io.FileNotFoundException;

public class Pessoa {
    public void save() throws InvalidLoginException, FileNotFoundException{
        System.out.println("Saving people...");
    }
}
