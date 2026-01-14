package src.poo.enums.classes;

public enum typePayment {
    DEBIT{
        @Override
        public double calcularDesconto(double value){
            return value * 0.1;
        }
    },
    CREDIT{
        @Override
        public double calcularDesconto(double value){
            return value * 0.05;
        }
    };

    public abstract double calcularDesconto(double value);

}
