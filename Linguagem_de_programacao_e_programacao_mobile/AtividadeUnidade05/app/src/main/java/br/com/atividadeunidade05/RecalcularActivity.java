package br.com.atividadeunidade05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.com.atividadeunidade05.util.Util;
import br.com.atividadeunidade05.view.GUI;

public class RecalcularActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recalcular);

        EditText edSN1 = (EditText) findViewById(R.id.edSN1);
        EditText edSN2 = (EditText) findViewById(R.id.edSN2);
        Button btnRecalc = (Button) findViewById(R.id.btnRecalc);
        TextView tvResultado = (TextView) findViewById(R.id.tvResultSubs);

        Intent intent = getIntent();

        Bundle extras = intent.getExtras();

        if(extras != null){

            edSN1.setText( String.valueOf(extras.getFloat("n1")) );
            edSN2.setText( String.valueOf(extras.getFloat("n2")) );

        }

        btnRecalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                float n1 = Float.parseFloat( edSN1.getText().toString().isEmpty() ? "0" : edSN1.getText().toString() );
                float n2 = Float.parseFloat( edSN2.getText().toString().isEmpty() ? "0" : edSN2.getText().toString() );

                //GUI.lancarToast(getApplicationContext(), "N1: "+n1+"\nN2: "+n2);

                if(Util.validarNota( n1) && Util.validarNota( n2)){

                    float resultado = Util.calularNota( n1, n2 );

                    if(resultado < 0){
                        GUI.lancarToast(getApplicationContext(), "Houve um erro ao calcular.");
                    }else{
                        tvResultado.setText( String.valueOf(resultado) );
                    }

                }else {
                    GUI.lancarToast(getApplicationContext(), "Valor inválido");
                }
            }
        });

    }
}