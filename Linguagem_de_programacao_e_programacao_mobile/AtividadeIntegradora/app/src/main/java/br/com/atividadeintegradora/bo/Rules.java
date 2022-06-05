package br.com.atividadeintegradora.bo;

import android.content.Context;

import java.util.List;

import br.com.atividadeintegradora.model.GenerosDAO;

public class Rules {

    Context context;

    public Rules(Context context){
        this.context = context;
    }

    public boolean onStart(){
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
