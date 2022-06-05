package br.com.atividadeintegradora.bo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import br.com.atividadeintegradora.entities.DBHelper;
import br.com.atividadeintegradora.model.GenerosDAO;
import br.com.atividadeintegradora.model.Pessoa;
import br.com.atividadeintegradora.model.PessoaDAO;

public class Rules {

    Context context;

    public Rules(Context context){
        this.context = context;
    }

    public boolean onStart(){
        /*DBHelper helper = new DBHelper(this.context);
        SQLiteDatabase db = helper.getWritableDatabase();
        helper.onUpgrade(db, 1, 2);*/

        GenerosDAO gdao = new GenerosDAO(this.context);

        List l = gdao.buscaTodosGeneros();

        if(l.size() == 0){

            if(gdao.inserirGenerosDefault()){
                return true;
            }

            return false;
        }

        return true;
    }

    public int cadastrar(Pessoa p){

        try{

            if(p.getNome().isEmpty()){
                return 0;
            }

            if(p.getNomeSocial().isEmpty()){
                return 1;
            }

            if(p.getRenda() < 0 ){
                return 2;
            }

            if(p.getGenero().isEmpty()){
                return 3;
            }

            PessoaDAO pdao = new PessoaDAO(this.context);

            long novoId = pdao.cadastrar(p);

            if(novoId > 0){
                return 5;
            }

            return 4;

        }catch (Exception e){
            return -1;
        }
    }

}
