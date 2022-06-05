package br.com.atividadeintegradora.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.fragment.app.DialogFragment;

import java.util.Arrays;
import java.util.List;

import br.com.atividadeintegradora.R;
import br.com.atividadeintegradora.model.Generos;
import br.com.atividadeintegradora.model.GenerosDAO;
import br.com.atividadeintegradora.model.Pessoa;
import br.com.atividadeintegradora.model.PessoaDAO;

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
        spPai.setOnItemSelectedListener(spPai.getOnItemSelectedListener());
        spMae.setOnItemSelectedListener(spMae.getOnItemSelectedListener());
        spGenero.setOnItemSelectedListener(spGenero.getOnItemSelectedListener());

        GenerosDAO gdao = new GenerosDAO(getContext());
        PessoaDAO pdao = new PessoaDAO(getContext());


        List<String> listGeneros = gdao.buscaTermo();
        List<String> listPessoas = pdao.buscaNome();

        if(listGeneros.size() == 0){
            listGeneros = Arrays.asList(new String[]{"Nenhum gênero encontrado"});
        }

        if(listPessoas.size() == 0){
            listPessoas = Arrays.asList(new String[]{"Nenhuma pessoa cadastrada"});
        }

        ArrayAdapter<String> adapterGeneros = new ArrayAdapter<String>(getActivity(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listGeneros);
        ArrayAdapter<String> adapterPessoas = new ArrayAdapter<String>(getActivity(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listPessoas);

        adapterPessoas.setDropDownViewResource(R.layout.spinner_layout);
        adapterGeneros.setDropDownViewResource(R.layout.spinner_layout);

        spGenero.setAdapter(adapterGeneros);
        spMae.setAdapter(adapterPessoas);
        spPai.setAdapter(adapterPessoas);

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
                String nome = edNome.getText().toString();
                String nomeSocial = edNomeSocial.getText().toString();
                float renda = Float.parseFloat(edRenda.getText().toString());

                //String genero = spGenero.get

                GUI.lancarToast(v.getContext(), "Clicou em salvar");
            }
        });

        //spGenero.getOnItemSelectedListener()


        return builder.create();
    }

}
