package com.example.andrei.dictionar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Andrei on 11/14/2017.
 */

public class DBManager {

    private SQLiteDatabase sqlDB;

    static final String DBName = "Cuvinte din dictionar";
    static final String TabelCuvinte = "Cuvinte";
    static final String ColID = "ID";
    static final String ColRo = "CuvantRO";
    static final String ColEng = "CuvantENG";
    static final int DBVersion = 1;

    static final String CreateTable = "Create table IF NOT EXISTS " + TabelCuvinte  +"("+ ColID +" integer PRIMARY KEY AUTOINCREMENT," + ColRo + " text," + ColEng + " text)";

    private static class DatabaseHelperMarket extends SQLiteOpenHelper {

        Context context;
        DatabaseHelperMarket(Context context){
            super(context, DBName, null, DBVersion);
            this.context = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CreateTable);
            Toast.makeText(context, "Table is created", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("Drop table IF EXISTS " + TabelCuvinte);
            onCreate(db);
        }
    }

    public DBManager(Context context){

        DatabaseHelperMarket db = new DatabaseHelperMarket(context);
        sqlDB = db.getWritableDatabase();

    }

    public long InsertCuvinte(ContentValues values){

        long ID = sqlDB.insert(TabelCuvinte,"",values);
        return ID;

    }

    public Cursor query(String[] Projection, String Selection, String[] SelectionArgs, String SortOrder){
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables(TabelCuvinte);

        Cursor cursor = qb.query(sqlDB, Projection, Selection, SelectionArgs, null, null, SortOrder);
        return cursor;
    }

    public int Delete(String Selection, String[] SelectionArgs){
        int count = sqlDB.delete(TabelCuvinte, Selection, SelectionArgs);
        return count;
    }

    public int Update(ContentValues values, String Selection, String[] SelectionArgs){
        int count = sqlDB.update(TabelCuvinte, values, Selection, SelectionArgs);
        return count;
    }




}
