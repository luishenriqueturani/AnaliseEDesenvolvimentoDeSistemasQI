package br.com.atividadeunidade05.util;

import br.com.atividadeunidade05.view.GUI;

public class Util {

    public static float calularNota(float n1, float n2){
        try{
            if(validarNota(n1)){
                return 0;
            }
            if(validarNota(n2)){
                return 0;
            }
            return (n1 + n2)/2;
        }catch (Exception e){
            GUI.lancarToast(MyApp.getContext(),"Error: " + e.toString());
            return 0;
        }
    }

    public static boolean validarNota(float n){
        try{

            if(n < 0){
                GUI.lancarToast(MyApp.getContext(),"A nota não pode ser menor que 0.");
                return false;
            }
            if(n > 10){
                GUI.lancarToast(MyApp.getContext(),"A nota não pode ser maio do que 10.");
                return false;
            }

            return true;
        }catch (Exception e){
            GUI.lancarToast(MyApp.getContext(),"Error: " + e.toString());
            return false;
        }
    }
}
