package br.com.atividadeintegradora.entities;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class CRUD {

    /**
     *
     * @param tableName string com o nome da tabela
     * @param values objeto ContentValues com os valores dos campos
     * @param db objeto do banco de dados sqlite, precisa ser um getWritableDatabase()
     *
     * @return retorna valor long com o novo id gerado, como um insert id
     *
     * */
    public static long insert(String tableName, ContentValues values, SQLiteDatabase db){
        return db.insert(tableName, null, values);
    }

    /**
     *
     * @param tableName string com o nome da tabela
     * @param selection cláusula where da query
     * @param selectionArgs são os argumentos de selecão para a query
     * @param db objeto do banco de dados sqlite, precisa ser um getWritableDatabase()
     *
     * @return valor inteiro indicando quantas linhas foram afetadas, caso seja negativo indica que deu erro
     *
     * */
    public static int delete(String tableName, String selection, String[] selectionArgs, SQLiteDatabase db){
        return db.delete(tableName, selection, selectionArgs);
    }

    /**
     *
     * @param tableName string com o nome da tabela
     * @param selection cláusula where da query
     * @param selectionArgs são os argumentos de selecão para a query
     * @param db objeto do banco de dados sqlite, precisa ser um getWritableDatabase()
     * @param values os valores que seram colocados
     *
     * @return valor inteiro indicando quantas linhas foram afetadas, caso seja negativo indica que deu erro
     *
     * */
    public static int update(String tableName, String selection, String[] selectionArgs, SQLiteDatabase db, ContentValues values){
        return db.update(
                tableName,
                values,
                selection,
                selectionArgs
        );
    }

    /**
     *
     * @param db
     * @param tableName
     * @param projection
     * @param colunaWhere
     * @param argumentosWhere
     * @param groupBy
     * @param having
     * @param orderBy
     *
     * @return cursor
     *
     * */
    public static Cursor select(SQLiteDatabase db, String tableName, String[] projection, String colunaWhere, String[] argumentosWhere, String groupBy, String having, String orderBy){
        Cursor cursor = db.query(
                tableName,
                projection,
                colunaWhere,
                argumentosWhere,
                groupBy,
                having,
                orderBy
        );
        return cursor;
    }
}
