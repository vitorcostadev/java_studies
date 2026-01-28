package src.exceptions.tests.runtime;

public class RuntimeExceptionTest03 {
    static void main() {
        try{
            System.out.println("Abrindo arquivo");
            throw new Exception("Erro");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("Arquivo fechado.");
        }
    }
}
