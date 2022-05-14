package br.com.atividadeunidade04.bo;

public interface ICalculosVenda {
    String calcularVenda(double valor, int quantidade);

    String calcularVenda(double valor, int quantidade, float desconto);
}
