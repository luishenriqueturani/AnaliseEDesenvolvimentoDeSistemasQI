package br.com.atividadeunidade04;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.atividadeunidade04.bo.CalculosVenda;
import br.com.atividadeunidade04.model.Vendas;
import br.com.atividadeunidade04.util.Validador;
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
        TextView tvResultado    = (TextView) findViewById(R.id.tvResultado);
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

                    if(Validador.validaNegativo(v.getValor())){
                        GUI.lancarToast(context, "Por favor, informe um valor positivo.");
                        return;
                    }

                    if(Validador.validaNegativo(v.getQuantidade())){
                        GUI.lancarToast(context, "Por favor, informe uma quantidade maior que 0.");
                        return;
                    }

                    double resultado;

                    if ( v.getDesconto() != 0 ) {
                         resultado = cv.calcularVenda( v.getValor(), v.getQuantidade(), v.getDesconto() ) ;

                    }else{
                         resultado = cv.calcularVenda( v.getValor(), v.getQuantidade(), v.getDesconto() ) ;
                    }

                    tvResultado.setText("R$ "+resultado);

                }catch (Exception e){
                    GUI.lancarToast(context, "Erro: "+e);
                }
            }
        });





    }
}