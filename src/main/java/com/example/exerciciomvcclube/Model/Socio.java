package com.example.exerciciomvcclube.Model;

import java.util.ArrayList;
import java.util.List;

public class Socio {
    private long cartao;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private List dependentes = new ArrayList<Dependente>();

    private void registroSocio () {
        System.out.println("numero cartao: " + cartao);
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private void consSocio () {
        System.out.println("nome: " + nome + "\n" + "endereco: " + endereco + "\n" + "telefone: " + telefone + "\n" + "email: " + email);
    }

    public void adicionarDependente (Dependente dependente){
        dependentes.add(dependente);
    }
}
