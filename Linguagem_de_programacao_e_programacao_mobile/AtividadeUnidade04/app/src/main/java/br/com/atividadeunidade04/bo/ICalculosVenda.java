package br.com.atividadeunidade04.bo;

import org.json.JSONException;

public interface ICalculosVenda {
    String calcularVenda(double valor, int quantidade) throws JSONException;

    String calcularVenda(double valor, int quantidade, float desconto) throws JSONException;
}
