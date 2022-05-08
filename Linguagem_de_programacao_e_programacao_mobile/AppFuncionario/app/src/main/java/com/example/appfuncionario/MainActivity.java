package com.example.appfuncionario;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText nome = (EditText) findViewById(R.id.txt_nome);
        EditText cargo = (EditText) findViewById(R.id.txt_cargo);
        EditText telefone = (EditText) findViewById(R.id.txt_telefone);

        Button btnGravar = (Button) findViewById(R.id.btn_gravar);

        btnGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                CharSequence text = "Nome: "+nome.getText()+"\nCargo: "+cargo.getText()+"\nTelefone: "+telefone.getText();
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, text, duration);

                toast.show();
            }
        });
    }


}