package br.com.atividadeunidade04;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import br.com.atividadeunidade04.bo.CalculosVenda;
import br.com.atividadeunidade04.model.Vendas;
import br.com.atividadeunidade04.view.GUI;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CalculosVenda cv = new CalculosVenda();

        EditText edValor        = (EditText) findViewById(R.id.edValor);
        EditText edQuantidade   = (EditText) findViewById(R.id.edQuantidade);
        EditText edDesconto     = (EditText) findViewById(R.id.edDesconto);
        EditText edResultado    = (EditText) findViewById(R.id.edResultado);
        Button btnCalcular      = (Button) findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                try {
                    Vendas v = new Vendas(Double.parseDouble(edValor.getText().toString()),
                            Integer.parseInt(edQuantidade.getText().toString()),
                            Float.parseFloat(edDesconto.getText().toString())
                    );
                    float desconto = v.getDesconto();

                    JSONArray retornoCalculo;

                    if ( desconto != 0 ) {
                        retornoCalculo = new JSONArray( cv.calcularVenda( v.getValor(), v.getQuantidade(), v.getDesconto() ) );

                    }else{
                        retornoCalculo = new JSONArray( cv.calcularVenda( v.getValor(), v.getQuantidade(), v.getDesconto() ) );

                    }

                    JSONObject jo = new JSONObject(retornoCalculo.getString(0));

                    if((boolean)jo.getBoolean("success")){
                        edResultado.setText((int) jo.getDouble("resultado"));
                    }else{
                        GUI.lancarToast(context, jo.get("erro").toString());
                    }

                }catch (Exception e){
                    GUI.lancarToast(context, "Erro: "+e);
                }
            }
        });





    }
}