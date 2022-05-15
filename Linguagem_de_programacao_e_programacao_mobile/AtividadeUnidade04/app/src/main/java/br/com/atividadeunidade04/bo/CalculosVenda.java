package br.com.atividadeunidade04.bo;


import org.json.JSONException;
import org.json.JSONObject;

public class CalculosVenda implements ICalculosVenda {

    /**
     *
     * @param valor - valor unitário do produto em double
     * @param quantidade - quantidade do produto em inteiro
     *
     * @return String com o resultado ou a exception ocorrida dentro de um toast
     *
     * */
    @Override
    public String calcularVenda(double valor, int quantidade) throws JSONException {
        try {
            double resultado = valor * quantidade;

            JSONObject retorno = new JSONObject("[{\"success\": true,\"resultado\": "+ resultado +"}]");

            return retorno.toString();

        }catch (Exception e){
            JSONObject retorno = new JSONObject("[{\"success\": false,\"erro\": "+ e +"}]");

            return retorno.toString();
        }

    }

    /**
     *
     * @param valor - valor unitário do produto em double
     * @param quantidade - quantidade do produto em inteiro
     * @param desconto - valor do desconto em float
     *
     * @return String com o resultado ou a exception ocorrida dentro de um toast
     *
     * */
    @Override
    public String calcularVenda(double valor, int quantidade, float desconto) throws JSONException {

        try {
            double resultado = valor * quantidade;

            double valorDesconto = resultado * (desconto/100);

            resultado -= valorDesconto;

            JSONObject retorno = new JSONObject("[{\"success\": true,\"resultado\": "+ resultado +"}]");

            return retorno.toString();

        }catch (Exception e){
            JSONObject retorno = new JSONObject("[{\"success\": false,\"erro\": "+ e +"}]");

            return retorno.toString();
        }

    }

}
