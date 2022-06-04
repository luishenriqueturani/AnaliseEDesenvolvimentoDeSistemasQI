package br.com.atividadeintegradora;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import br.com.atividadeintegradora.view.DialogCadastro;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        * on start
        * */



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