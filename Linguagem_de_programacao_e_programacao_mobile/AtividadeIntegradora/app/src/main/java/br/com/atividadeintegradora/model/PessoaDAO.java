package br.com.atividadeintegradora.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

import br.com.atividadeintegradora.entities.BDContract;
import br.com.atividadeintegradora.entities.CRUD;
import br.com.atividadeintegradora.entities.DBHelper;

public class PessoaDAO {

    DBHelper dbHelper;
    Context context;

    public PessoaDAO(Context context) {
        this.dbHelper = new DBHelper(context);
        this.context = context;
    }

    public List<Pessoa> buscarTodasPessoas(){
        try {

            SQLiteDatabase db = dbHelper.getReadableDatabase();

            String[] projection = {
                    BaseColumns._ID,
                    BDContract.PessoasEntry.COLUMN_NAME_NOME,
                    BDContract.PessoasEntry.COLUMN_NAME_GENERO,
                    BDContract.PessoasEntry.COLUMN_NAME_NOME_SOCIAL,
                    BDContract.PessoasEntry.COLUMN_NAME_PAI,
                    BDContract.PessoasEntry.COLUMN_NAME_MAE,
                    BDContract.PessoasEntry.COLUMN_NAME_RENDA
            };

            Cursor cursor = CRUD.select(db, BDContract.PessoasEntry.TABLE_NAME, projection, null, null, null, null, null);

            List<Pessoa> l = new ArrayList<>();
            GenerosDAO gdao = new GenerosDAO(this.context);

            while (cursor.moveToNext()){
                long id = cursor.getLong(cursor.getColumnIndexOrThrow(BDContract.PessoasEntry._ID));
                long genero = cursor.getLong(cursor.getColumnIndexOrThrow(BDContract.PessoasEntry.COLUMN_NAME_GENERO));
                String nome = cursor.getString(cursor.getColumnIndexOrThrow(BDContract.PessoasEntry.COLUMN_NAME_NOME));
                String nomeSocial = cursor.getString(cursor.getColumnIndexOrThrow(BDContract.PessoasEntry.COLUMN_NAME_NOME_SOCIAL));
                float renda = cursor.getFloat(cursor.getColumnIndexOrThrow(BDContract.PessoasEntry.COLUMN_NAME_RENDA));
                long pai = cursor.getLong(cursor.getColumnIndexOrThrow(BDContract.PessoasEntry.COLUMN_NAME_PAI));
                long mae = cursor.getLong(cursor.getColumnIndexOrThrow(BDContract.PessoasEntry.COLUMN_NAME_MAE));

                String termo = gdao.buscaTermoPorID(genero);

                String nomePai = buscaNomePorId(pai);
                String nomeMae = buscaNomePorId(mae);

                Pessoa p = new Pessoa( id, nome, nomeSocial, termo, renda, nomePai, nomeMae );

                l.add(p);
            }
            cursor.close();

            return l;

        }catch (Exception e){
            return null;
        }
    }

    public String buscaNomePorId(long id){
        try{
            SQLiteDatabase db = dbHelper.getReadableDatabase();

            String[] projection = {
                    BDContract.PessoasEntry.COLUMN_NAME_NOME
            };

            String coluna = BDContract.PessoasEntry._ID + " LIKE ? ";
            String[] args = {String.valueOf(id)};

            Cursor cursor = CRUD.select(db, BDContract.PessoasEntry.TABLE_NAME, projection, coluna, args, null, null, null);

            String nome = null;
            while (cursor.moveToNext()){
                nome = cursor.getString(cursor.getColumnIndexOrThrow(BDContract.PessoasEntry.COLUMN_NAME_NOME));

            }
            cursor.close();

            return nome;
        }catch (Exception e){
            return null;
        }
    }

    public List<String> buscaNome(){
        try{
            SQLiteDatabase db = dbHelper.getReadableDatabase();

            String[] projection = {
                    BDContract.PessoasEntry.COLUMN_NAME_NOME
            };

            Cursor cursor = CRUD.select(db, BDContract.PessoasEntry.TABLE_NAME, projection, null, null, null, null, null);

            String nome = null;
            List<String> l = new ArrayList<>();
            while (cursor.moveToNext()){
                nome = cursor.getString(cursor.getColumnIndexOrThrow(BDContract.PessoasEntry.COLUMN_NAME_NOME));

                l.add(nome);
            }
            cursor.close();

            return l;
        }catch (Exception e){
            return null;
        }
    }


}
