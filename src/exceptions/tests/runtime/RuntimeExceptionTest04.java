package src.exceptions.tests.runtime;

public class RuntimeExceptionTest04 {
    static void main() {
        try{
            throw new RuntimeException();
        }catch(ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }catch(IllegalArgumentException e){
            e.printStackTrace();
        }catch(IndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }
}
