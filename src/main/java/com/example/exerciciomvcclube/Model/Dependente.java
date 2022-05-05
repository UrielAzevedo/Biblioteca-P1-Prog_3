package com.example.exerciciomvcclube.Model;

public class Dependente {

    long cartao;
    private String nome;
    private String parentesco;
    private String email;
    Socio socioAssociado;

    Dependente (Socio socioAssociado){
        this.socioAssociado = socioAssociado;
    }

    public void novoDependente (Dependente novoDependente) {
        socioAssociado.adicionarDependente(novoDependente);
    }

    public long getCartao() {
        return cartao;
    }

    public void setCartao(long cartao) {
        this.cartao = cartao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
