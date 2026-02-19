package desafios.sistema;

import desafios.sistema.domain.Pets;
import desafios.sistema.services.MenuService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MenuService menu = new MenuService(new Scanner(System.in));
        try {
            Pets pet = (Pets) menu.getDataFromConsole(1);
            System.out.println(pet);
        } catch (IllegalStateException e) {
            throw new RuntimeException(e);
        }
    }
}
