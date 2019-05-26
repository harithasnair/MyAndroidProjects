package com.harithasnair.anagram_sqlite;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelperClass extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Anagram_Sqlite.db";
    public static final String TABLE_NAME = "wordsTable";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "ToBeSolvedWords";


    public DatabaseHelperClass(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table wordsTable(ID INTEGER PRIMARY KEY AUTOINCREMENT, ToBeSolvedWords TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      db.execSQL("drop table if exists wordsTable");
      onCreate(db);
    }



}
