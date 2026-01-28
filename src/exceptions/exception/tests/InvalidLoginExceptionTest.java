package src.exceptions.exception.tests;

import java.util.Scanner;
import src.exceptions.exception.domain.InvalidLoginException;

public class InvalidLoginExceptionTest {
    static void main() {
        try {
            login();
        } catch (InvalidLoginException e) {
            e.printStackTrace();
        }
    }

    private static void login() throws InvalidLoginException {

        Scanner scan = new Scanner(System.in);
        String usernamedb = "Asuna";
        String passworddb = "op2123";

        String scannerUsername;
        String scannerPassword;

        System.out.println("Usuário: "); scannerUsername=scan.nextLine();
        System.out.println("Senha: "); scannerPassword=scan.nextLine();

        if(!usernamedb.equals(scannerUsername) || !passworddb.equals(scannerPassword)){
            throw new InvalidLoginException("Dados inválidos!");
        }

        System.out.println("Usuario logado com sucesso.");
    }
}
