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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edN1 = (EditText) findViewById(R.id.edN1);
        EditText edN2 = (EditText) findViewById(R.id.edN2);
        Button btnCalcular = (Button) findViewById(R.id.btnCalcular);
        Button btnSubs = (Button) findViewById(R.id.btnSubstituicao);
        TextView tvResultado = (TextView) findViewById(R.id.tvResultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                float n1 = Float.parseFloat( edN1.getText().toString().isEmpty() ? "0" : edN1.getText().toString() );
                float n2 = Float.parseFloat( edN2.getText().toString().isEmpty() ? "0" : edN2.getText().toString() );

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

        btnSubs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                Intent mainToRecalcular = new Intent(getApplicationContext(), RecalcularActivity.class);

                extras.putFloat("n1", Float.parseFloat( edN1.getText().toString().isEmpty() ? "0" : edN1.getText().toString() ));
                extras.putFloat("n2", Float.parseFloat( edN2.getText().toString().isEmpty() ? "0" : edN2.getText().toString() ));

                mainToRecalcular.putExtras(extras);

                startActivity(mainToRecalcular);
            }
        });



    }
}