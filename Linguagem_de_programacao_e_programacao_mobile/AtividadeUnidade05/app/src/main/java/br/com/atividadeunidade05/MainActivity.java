package br.com.atividadeunidade05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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







    }
}