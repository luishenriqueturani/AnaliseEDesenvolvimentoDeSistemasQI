package br.com.atividadeintegradora.entities;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {
    private static final String CREATE_ENTRIES_PESSOAS = "" +
            "CREATE TABLE IF NOT EXISTS " + BDContract.PessoasEntry.TABLE_NAME + " (" +
            BDContract.PessoasEntry._ID + " INTEGER PRIMARY KEY," +
            BDContract.PessoasEntry.COLUMN_NAME_NOME + " VARCHAR(500)," +
            BDContract.PessoasEntry.COLUMN_NAME_NOME_SOCIAL + " VARCHAR(500)," +
            BDContract.PessoasEntry.COLUMN_NAME_GENERO + " INTEGER," +
            BDContract.PessoasEntry.COLUMN_NAME_RENDA + " REAL);";

    private static final String CREATE_ENTRIES_GENEROS = "" +
            "CREATE TABLE IF NOT EXISTS " + BDContract.GenerosEntry.TABLE_NAME + " (" +
            BDContract.GenerosEntry._ID + " INTEGER PRIMARY KEY," +
            BDContract.GenerosEntry.COLUMN_NAME_TERMO + " VARCHAR(250));";

    private static final String DELETE_ENTRIES_PESSOAS = "DROP TABLE IF EXISTS " + BDContract.PessoasEntry.TABLE_NAME + ";";
    private static final String DELETE_ENTRIES_GENEROS = "DROP TABLE IF EXISTS " + BDContract.GenerosEntry.TABLE_NAME + ";";

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "atividade_integradora.db";

    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_ENTRIES_PESSOAS);
        db.execSQL(CREATE_ENTRIES_GENEROS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DELETE_ENTRIES_GENEROS);
        db.execSQL(DELETE_ENTRIES_PESSOAS);
        onCreate(db);
    }
}
