package src.projetins.sistemaDeCadastro.domain;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    private FileWriter fileWriter;

    public Writer(FileWriter fw){
        this.fileWriter = fw;
    }

    public boolean addProduct(Produto produto) throws IOException{
        if(produto != null){
            try(BufferedWriter bw = new BufferedWriter(this.fileWriter)) {
                bw.write(produto.toString());
                bw.newLine();
                bw.flush();

                return true;
            }
        }

        return false;
    }
}
