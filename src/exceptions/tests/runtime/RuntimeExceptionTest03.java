package src.exceptions.tests.runtime;

public class RuntimeExceptionTest03 {
    public static void main(String[] args) {
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
