package src.regex.tests;

public class ScannerTest {
    public static void main(String[] args) {
        String texto = "Asuna, Nami, Nico Robin, Kaguya Ootsuki, Ai Hoshino, Kana Arima, Akane Kurokawa";
        String[] split = texto.split(",");

        for(String str : split){
            System.out.println(str.trim());
        }

    }
}
