package com.acaizaguano.apps.androidfunwithflags;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class BDHelper extends SQLiteOpenHelper {


    private  String createTable_Resultados = "CREATE TABLE Resultados" +
            "(Codigo INTEGER PRIMARY KEY AUTOINCREMENT," +
            "Usuario TEXT," +
            "Nivel TEXT," +
            "Puntaje INTEGER)";


    public BDHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(createTable_Resultados);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS Resultados");
        db.execSQL(createTable_Resultados);

    }
}
