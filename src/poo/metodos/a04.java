package src.poo.metodos;

import src.poo.metodos.classes.Anime;


public class a04 {
    public static void main(String[] args) {
        // Sobrecarga de metódos

        Anime anime = new Anime("Otonari no tenshi-sama", "Cloverworks");
        anime.init("Manga", 12);

        anime.printInfo();
    }
    
}
