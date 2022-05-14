package br.com.atividadeunidade04.model;

public class Vendas {
    private double valor;
    private int quantidade;
    private float desconto;

    public Vendas(double valor, int quantidade, float desconto) {
        this.valor = valor;
        this.quantidade = quantidade;
        this.desconto = desconto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }
}
