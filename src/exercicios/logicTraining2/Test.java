package src.exercicios.logicTraining2;

public class Test {
    void main(){
        try{
            Produto produto = new Produto("Agua", 1, 1);
            System.out.println(produto);

            produto.setStock(1);
            System.out.println("Stock: "+ produto.getStock());
            produto.setValue(1);
            System.out.println("Value: "+ produto.getValue());
            
        }catch(RuntimeException e){
            e.printStackTrace();
        }
    }
}
