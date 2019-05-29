package com.harithasnair.anagram_sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseHelperClass extends SQLiteOpenHelper {

    private  String DB_PATH = "";
    private static String DB_NAME = "word.db";
    private SQLiteDatabase mDatabase;
    private final Context mContext;

    public DatabaseHelperClass(Context context) {
        super(context, DB_NAME, null, 1);
        this.mContext = context;
        this.DB_PATH = (mContext.getPackageName() +"/assets/databases/");
        Log.e("path 1", DB_PATH);
    }

    public void createDataBase() throws IOException {
        boolean DBExist = checkDataBase();
        if (DBExist) {
        } else {
            this.getReadableDatabase();
            try {
                copyDataBase();
            } catch (IOException e) {
                throw new Error("Error copying database");
            }
        }
    }


    public boolean checkDataBase() {
        SQLiteDatabase tempDB = null;
        try {
            String path = DB_PATH+DB_NAME;
            tempDB = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e) {
        }
        if (tempDB != null) {
            tempDB.close();
        }
        return tempDB != null ? true : false;
    }

    private void copyDataBase() throws IOException {
        InputStream myInput = mContext.getAssets().open("word.db");
        String outputFileName = DB_PATH+DB_NAME;
        OutputStream myOutput = new FileOutputStream(outputFileName);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }


    public void openDataBase() {
        String path = DB_PATH+DB_NAME;
        mDatabase = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
    }

    public synchronized void close() {
        if (mDatabase != null)
            mDatabase.close();
        super.close();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion)
            try {
                copyDataBase();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public Cursor query(String table, String[] columns, String selection, String[] selectionArgs, String groupby, String having, String orderBy) {
        return mDatabase.query("table", null, null, null, null, null, null);
    }
}



