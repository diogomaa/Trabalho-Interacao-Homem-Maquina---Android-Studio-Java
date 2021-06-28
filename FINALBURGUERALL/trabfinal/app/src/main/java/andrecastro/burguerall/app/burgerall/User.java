package andrecastro.burguerall.app.burgerall;

import java.io.Serializable;

public class User implements Serializable {

    String email;
    String password;
    String telefone;

    String nome;
    String apelido;
    String NIF;
    String morada;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getApelido() {
        return apelido;
    }

    public String getNIF() {
        return NIF;
    }

    public String getMorada() {
        return morada;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }
}
