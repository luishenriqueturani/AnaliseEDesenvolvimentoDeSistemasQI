package br.com.atividadeunidade05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.com.atividadeunidade05.util.MyApp;
import br.com.atividadeunidade05.util.Util;

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
                tvResultado.setText( String.valueOf(Util.calularNota( Float.parseFloat(edN1.getText().toString()), Float.parseFloat(edN2.getText().toString()) )) );
            }
        });

        btnSubs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                Intent mainToRecalcular = new Intent(MyApp.getContext(), RecalcularActivity.class);

                extras.putFloat("n1", Float.parseFloat(edN1.getText().toString()));
                extras.putFloat("n2", Float.parseFloat(edN2.getText().toString()));

                mainToRecalcular.putExtras(extras);

                startActivity(mainToRecalcular);
            }
        });



    }
}