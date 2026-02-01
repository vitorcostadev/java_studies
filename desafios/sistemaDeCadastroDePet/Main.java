package desafios.sistemaDeCadastroDePet;

import java.io.IOException;

import desafios.sistemaDeCadastroDePet.services.MenuService;

public class Main {
    public static void main(String[] args) {
        MenuService menu = new MenuService();
        try {
            menu.startMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
