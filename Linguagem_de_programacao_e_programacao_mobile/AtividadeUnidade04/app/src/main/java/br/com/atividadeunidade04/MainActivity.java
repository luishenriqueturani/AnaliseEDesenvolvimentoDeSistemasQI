package br.com.atividadeunidade04;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

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

                    if ( desconto != 0 ) {
                        JSONObject retornoCalculo = new JSONObject(cv.calcularVenda(v.getValor(), v.getQuantidade(), v.getDesconto()));

                        if((boolean)retornoCalculo.get("success")){
                            edResultado.setText(retornoCalculo.get("resultado").toString());
                        }else{
                            GUI.lancarToast(context, retornoCalculo.get("erro").toString());
                        }

                    }else{
                        String retornoCalculo = cv.calcularVenda(v.getValor(), v.getQuantidade());

                    }
                }catch (Exception e){
                    GUI.lancarToast(context, "Erro: "+e);
                }
            }
        });





    }
}