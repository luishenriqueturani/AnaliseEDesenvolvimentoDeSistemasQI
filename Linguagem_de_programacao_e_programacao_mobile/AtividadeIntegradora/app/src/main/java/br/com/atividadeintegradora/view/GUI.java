package br.com.atividadeintegradora.view;

import android.content.Context;
import android.widget.Toast;

public class GUI {

    /**
     *
     * @param context contexto da aplicacão
     * @param mensagem mensagem que será mostrada
     *
     * */
    public static void lancarToast(Context context, String mensagem){
        CharSequence text = mensagem;
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);

        toast.show();
    }
}
