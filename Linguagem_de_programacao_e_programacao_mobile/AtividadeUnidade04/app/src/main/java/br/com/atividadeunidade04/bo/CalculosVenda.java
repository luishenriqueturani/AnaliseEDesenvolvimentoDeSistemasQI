package br.com.atividadeunidade04.bo;

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
    public String calcularVenda(double valor, int quantidade){

        try {
            return "";
        }catch (Exception e){
            return "";
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
    public String calcularVenda(double valor, int quantidade, float desconto){

        try {
            return "";
        }catch (Exception e){
            return "";
        }

    }

}
