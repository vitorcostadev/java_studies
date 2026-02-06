package desafios.sistemaDeCadastroDePet;

import java.io.IOException;

import desafios.sistemaDeCadastroDePet.services.MenuService;

public class Main {
    public static void main(String[] args) {
        MenuService menu = new MenuService();
        try {
            menu.menu();
        } catch (IOException e) {
            System.out.println("An error occured in the MenuService: "+e.getLocalizedMessage());
            System.exit(0);
        }
    }
}
