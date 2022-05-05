package com.example.exerciciomvcclube.Model;

import java.util.Date;

public class Mensalidade {

    private Date data;
    private String nome;
    private Double valor;
    private Date dataPagamento;
    private Double juros;
    private Double valorPago;
    private boolean quitado;

    public void constarMensalidade () {
        if(!quitado){
            System.out.println("data: " + data + "\n" + "nome: " + nome + "\n" + "valor: " + valor + "\n" + "juros: " + juros + "\n" + "valorPago: " + valorPago);
        }
    }

    Double calcularJuros(){
        return (valor + valor * 0.2);
    }

    boolean quitarMensalidade (Double valorPago){
        if(valorPago + this.valorPago >= valor + juros){
            this.quitado = true;
            return true;
        }else{
            this.valorPago = this.valor + valorPago;
            System.out.println("pagamento ainda pendente no valor de: " + (this.valor - valorPago));
            return false;
        }
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Double getJuros() {
        return juros;
    }

    public void setJuros(Double juros) {
        this.juros = juros;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public boolean isQuitado() {
        return quitado;
    }

    public void setQuitado(boolean quitado) {
        this.quitado = quitado;
    }
}
