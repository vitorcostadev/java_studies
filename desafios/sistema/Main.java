package desafios.sistema;

import desafios.sistema.services.MenuService;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MenuService menu = new MenuService(new Scanner(System.in));
        try {
            menu.start();
        } catch (IllegalStateException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
