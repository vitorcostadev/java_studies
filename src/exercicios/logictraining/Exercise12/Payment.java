package src.exercicios.logictraining.Exercise12;

public enum Payment {
    MONEY(1){
        public double calcularImposto(Produto produto){
            return produto.getValor() - (produto.getValor() * 0.15);
        }
    },
    CREDIT(1){
        public double calcularImposto(Produto produto) {
            return produto.getValor() - (produto.getValor() * 0.1);
        }
    },
    DEBIT(2){
        @Override
        public double calcularImposto(Produto produto) {
            if(produto.getParcelas() > 0 && produto.getParcelas() <= 2){
                return produto.getValor() / produto.getParcelas();
            }

            return (produto.getValor() + (produto.getValor() * 0.1)) / produto.getParcelas();
        }
    };

    private int Indice;
    Payment(int Indice) { this.Indice = Indice; }

    public abstract double calcularImposto(Produto produto);
}
