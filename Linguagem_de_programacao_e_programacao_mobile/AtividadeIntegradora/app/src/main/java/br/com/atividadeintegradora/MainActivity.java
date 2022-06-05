package br.com.atividadeintegradora;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import br.com.atividadeintegradora.bo.PessoasAdapter;
import br.com.atividadeintegradora.bo.Rules;
import br.com.atividadeintegradora.model.Pessoa;
import br.com.atividadeintegradora.model.PessoaDAO;
import br.com.atividadeintegradora.view.DialogCadastro;
import br.com.atividadeintegradora.view.GUI;

public class MainActivity extends AppCompatActivity {
    ArrayList<Pessoa> pessoas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        * on start
        * */

        Rules r = new Rules(getApplicationContext());

        if(!r.onStart()){
            GUI.lancarToast(getApplicationContext(), "Houve um erro ao realizar as insercões de gêneros padrões");
        }

        PessoaDAO pdao = new PessoaDAO(getApplicationContext());

        pessoas = (ArrayList<Pessoa>) pdao.buscarTodasPessoas();

        PessoasAdapter adapter = new PessoasAdapter(pessoas);

        RecyclerView listaCadastrados = (RecyclerView) findViewById(R.id.listaCadastrados);

        listaCadastrados.setAdapter(adapter);
        listaCadastrados.setLayoutManager(new LinearLayoutManager(this));
        

        /*
         * Float button and dialog
         * */
        FloatingActionButton fabNovoCadastro = (FloatingActionButton) findViewById(R.id.fabNovoCadastro);

        fabNovoCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialog = new DialogCadastro();
                dialog.show(getSupportFragmentManager(), dialog.getTag());
            }
        });



    }
}