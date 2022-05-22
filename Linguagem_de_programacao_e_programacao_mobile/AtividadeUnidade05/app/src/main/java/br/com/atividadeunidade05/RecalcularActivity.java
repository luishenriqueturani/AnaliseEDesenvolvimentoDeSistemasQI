package br.com.atividadeunidade05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.com.atividadeunidade05.util.Util;

public class RecalcularActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recalcular);

        EditText edSN1 = (EditText) findViewById(R.id.edSN1);
        EditText edSN2 = (EditText) findViewById(R.id.edSN2);
        Button btnRecalc = (Button) findViewById(R.id.btnRecalc);
        TextView tvResultado = (TextView) findViewById(R.id.tvResultado);

        Intent intent = getIntent();

        Bundle extras = intent.getExtras();

        if(extras != null){

            edSN1.setText( String.valueOf(extras.getFloat("n1")) );
            edSN2.setText( String.valueOf(extras.getFloat("n2")) );

        }

        btnRecalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResultado.setText( String.valueOf(Util.calularNota( Float.parseFloat(edSN1.getText().toString()), Float.parseFloat(edSN2.getText().toString()) )) );
            }
        });

    }
}