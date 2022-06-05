package br.com.atividadeintegradora.bo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import br.com.atividadeintegradora.entities.DBHelper;
import br.com.atividadeintegradora.model.GenerosDAO;

public class Rules {

    Context context;

    public Rules(Context context){
        this.context = context;
    }

    public boolean onStart(){
        DBHelper helper = new DBHelper(this.context);
        SQLiteDatabase db = helper.getWritableDatabase();
        helper.onUpgrade(db, 1, 2);

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



}
