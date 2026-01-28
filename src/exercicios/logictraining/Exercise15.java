package src.exercicios.logictraining;

import java.security.SecureRandom;

public class Exercise15 {
    static void main() {
        SecureRandom random = new SecureRandom();

        int ano = random.nextInt(1900, 2025);

        int anos=0, meses=0, dias=0;

        System.out.println("Ano: "+ano);
        ano = (2026 - ano) * 365;

        do{
            if(ano >= 365){
                anos++;
                ano -= 365;
            }else if(ano >= 30){
                meses++;
                ano -= 30;
            }else{
                dias++;
                ano -= 1;
            }
        }while(ano > 0);

        System.out.println(anos + " anos, " + meses + " meses e "+dias+" dias.");
    }
}
