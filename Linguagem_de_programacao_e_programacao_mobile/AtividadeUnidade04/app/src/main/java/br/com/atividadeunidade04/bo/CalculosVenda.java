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
    public double calcularVenda(double valor, int quantidade) {
        try {
            double resultado = valor * quantidade;

            return resultado;

        }catch (Exception e){
            return -1;
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
    public double calcularVenda(double valor, int quantidade, float desconto){

        try {
            double resultado = valor * quantidade;

            double valorDesconto = resultado * (desconto/100);

            resultado -= valorDesconto;

            return resultado;

        }catch (Exception e){

            return -1;
        }

    }

}
