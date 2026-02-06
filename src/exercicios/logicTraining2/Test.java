package src.exercicios.logicTraining2;

public class Test {
    public static void main(String[] args) {
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
