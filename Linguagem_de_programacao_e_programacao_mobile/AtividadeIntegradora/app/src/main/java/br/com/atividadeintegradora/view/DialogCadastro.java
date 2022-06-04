package br.com.atividadeintegradora.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.fragment.app.DialogFragment;

import br.com.atividadeintegradora.R;

public class DialogCadastro extends DialogFragment {

    public Dialog onCreateDialog(Bundle savedInstanceState){

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        View dialogLayout = (View) getLayoutInflater().inflate(R.layout.dialog_cadastro, null);

        builder.setView(dialogLayout);

        EditText edNome = (EditText) dialogLayout.findViewById(R.id.edNome);
        EditText edNomeSocial = (EditText) dialogLayout.findViewById(R.id.edNomeSocial);
        EditText edRenda = (EditText) dialogLayout.findViewById(R.id.edRenda);

        Spinner spPai = (Spinner) dialogLayout.findViewById(R.id.spPai);
        Spinner spMae = (Spinner) dialogLayout.findViewById(R.id.spMae);
        Spinner spGenero = (Spinner) dialogLayout.findViewById(R.id.spGenero);

        Button btnCancel = (Button) dialogLayout.findViewById(R.id.btnCancelar);
        Button btnSalvar = (Button) dialogLayout.findViewById(R.id.btnSalvar);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogCadastro.this.getDialog().cancel();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GUI.lancarToast(v.getContext(), "Clicou em salvar");
            }
        });


        return builder.create();
    }

}
