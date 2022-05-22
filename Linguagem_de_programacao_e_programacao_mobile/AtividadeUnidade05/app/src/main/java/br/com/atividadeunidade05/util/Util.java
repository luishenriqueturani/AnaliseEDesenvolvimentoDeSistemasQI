package br.com.atividadeunidade05.util;


public class Util {

    public static float calularNota(float n1, float n2){
        try{
            return (n1 + n2)/2;

        }catch (Exception e){
            return -1;
        }
    }

    public static boolean validarNota(float n){
       try{

            if(n < 0){
                return false;
            }
            if(n > 10){
                return false;
            }

            return true;
        }catch (Exception e){
            return false;
        }
    }
}
