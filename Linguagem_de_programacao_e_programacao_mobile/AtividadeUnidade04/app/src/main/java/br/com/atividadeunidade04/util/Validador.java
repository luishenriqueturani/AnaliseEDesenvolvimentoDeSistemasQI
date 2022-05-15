package br.com.atividadeunidade04.util;

public class Validador {

    /**
     *
     * @param valor valor numérico em double
     *
     * @return boolean true se for menor que 0 ou der erro e false caso seja maior que 0
     *
     * */
    public static boolean validaNegativo(double valor){
        try{
            if(valor < 0){
                return true;
            }

            return false;

        }catch (Exception e){
            return true;
        }
    }



}
