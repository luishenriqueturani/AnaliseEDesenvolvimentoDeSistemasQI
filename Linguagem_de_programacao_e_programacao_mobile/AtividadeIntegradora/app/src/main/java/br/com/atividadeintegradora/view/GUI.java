package br.com.atividadeintegradora.view;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import br.com.atividadeintegradora.R;
import br.com.atividadeintegradora.model.Pessoa;

public class GUI {

    AlertDialog alerta;

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

    public void lancarDialog(Context context, Pessoa p){

        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        LayoutInflater inflater = new LayoutInflater(context) {
            @Override
            public LayoutInflater cloneInContext(Context newContext) {
                return null;
            }
        };

        View dLayout = (ViewGroup) inflater.inflate(R.layout.dialog_mostrar_cadastro, null);

        builder.setView(dLayout);

        EditText edNome = (EditText) dLayout.findViewById(R.id.edMDNome);
        EditText edNomeSocial = (EditText) dLayout.findViewById(R.id.edMDNomeSocial);
        EditText edRenda = (EditText) dLayout.findViewById(R.id.edMDRenda);
        EditText edGenero = (EditText) dLayout.findViewById(R.id.edMDGenero);
        EditText edMae = (EditText) dLayout.findViewById(R.id.edMDMae);
        EditText edPai = (EditText) dLayout.findViewById(R.id.edMDPai);

        edNome.setText(p.getNome());
        edNomeSocial.setText(p.getNomeSocial());
        edRenda.setText(String.valueOf(p.getRenda()));
        edGenero.setText(p.getGenero());
        edMae.setText(p.getMae());
        edPai.setText(p.getPai());

        alerta = builder.create();

        alerta.show();

    }
}
