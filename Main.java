import desafios.sistemaDeCadastroDePet.domain.AddressWhoFoundPet;
import desafios.sistemaDeCadastroDePet.domain.GenrePet;
import desafios.sistemaDeCadastroDePet.domain.Pets;
import desafios.sistemaDeCadastroDePet.domain.SearchCrit;
import desafios.sistemaDeCadastroDePet.services.MenuService;
import desafios.sistemaDeCadastroDePet.services.PetWriterAndReader;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

public class Main {
    static void main() throws IOException {
        MenuService menu = new MenuService();
        menu.menu();
    }
}
