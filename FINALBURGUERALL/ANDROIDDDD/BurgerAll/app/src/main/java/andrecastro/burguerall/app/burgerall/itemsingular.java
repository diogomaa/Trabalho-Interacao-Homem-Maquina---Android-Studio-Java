package andrecastro.burguerall.app.burgerall;

public class itemsingular {

    int imagem;
    String nome;
    double preco;

    public itemsingular(int imagem, String nome, double preco) {
        this.imagem = imagem;
        this.nome = nome;
        this.preco = preco;

    }

    public int getImagem() {
        return imagem;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

}
