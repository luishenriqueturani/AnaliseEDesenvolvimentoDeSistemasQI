package br.com.atividadeunidade04.bo;

public interface ICalculosVenda {

    double calcularVenda(double valor, int quantidade);

    double calcularVenda(double valor, int quantidade, float desconto);
}
