package br.com.atividadeintegradora.entities;

import android.provider.BaseColumns;

public class BDContract {
    public static class PessoasEntry implements BaseColumns{
        public static final String TABLE_NAME = "pessoas";
        public static final String COLUMN_NAME_NOME = "nome";
        public static final String COLUMN_NAME_NOME_SOCIAL = "nome_social";
        public static final String COLUMN_NAME_GENERO = "genero";
        public static final String COLUMN_NAME_RENDA = "renda";
        public static final String COLUMN_NAME_PAI = "pai";
        public static final String COLUMN_NAME_MAE = "mae";
    }

    public static class GenerosEntry implements BaseColumns{
        public static final String TABLE_NAME = "generos";
        public static final String COLUMN_NAME_TERMO = "termo";
    }
}
