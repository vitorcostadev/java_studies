import java.io.IOException;

import desafios.sistemaDeCadastroDePet.services.MenuService;

public class Main {
    static void main(){ 
        MenuService menu = new MenuService();
        try {
            menu.menu();
        } catch (IOException e) {
            System.out.println("An error occured in the MenuService: "+e.getLocalizedMessage());
            System.exit(0);
        }
    }
}
