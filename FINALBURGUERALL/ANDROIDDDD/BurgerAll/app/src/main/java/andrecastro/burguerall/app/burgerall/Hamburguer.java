package andrecastro.burguerall.app.burgerall;

import java.util.ArrayList;
import java.util.List;

public class Hamburguer {

    int imagem;
    String nome, desc;
    double phamb,pmenu;

    public Hamburguer(int imagem, String nome, String desc, double phamb, double pmenu) {
        this.imagem = imagem;
        this.nome = nome;
        this.desc = desc;
        this.phamb = phamb;
        this.pmenu = pmenu;
    }

    public int getImagem() {
        return imagem;
    }

    public String getNome() {
        return nome;
    }

    public String getDesc() {
        return desc;
    }

    public double getPhamb() {
        return phamb;
    }

    public double getPmenu() {
        return pmenu;
    }
}
