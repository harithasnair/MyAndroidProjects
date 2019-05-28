package com.harithasnair.anagram_sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;

public class DatabaseHelperClass extends SQLiteOpenHelper {

    private static String DB_PATH = "";
    private static String DB_NAME = "ANAGRAM.db";
    private SQLiteDatabase mDatabase;
    private Context mContext = null;

    public DatabaseHelperClass(Context context) {
        super(context, DB_NAME, null, 1);
        if (Build.VERSION.SDK_INT >= 22)
            DB_PATH = mContext.getApplicationInfo().dataDir + "/databases/";
        else
            DB_PATH = "/data/data/" + mContext.getPackageName() + "/databases/";
        mContext = context;
    }

    public synchronized void close() {
        if (mDatabase != null)
            mDatabase.close();
        super.close();
    }

    public boolean checkDataBase() {
        SQLiteDatabase tempDB = null;
        try {
            String path = DB_PATH + DB_NAME;
            tempDB = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        } catch (Exception e)
        if (tempDB != null)
            tempDB.close();
        return tempDB != null ? true : false;
    }


    public void copyDataBase() {
        try {
            InputStream myInput = mContext.getAssets().open(DB_NAME);
            String outputFileName = DB_PATH + DB_NAME;
            OutputStream myOutput = new FileOutputStream(outputFileName);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }
            myOutput.flush();
            myOutput.close();
            myInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openDataBase() {
        String path = DB_PATH + DB_NAME;
        mDatabase = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public void createDataBase() {
        boolean isDBExist = checkDataBase();
        if (isDBExist) {
        } else
            this.getReadableDatabase();
        try {
            copyDataBase();
        } catch (Exception e) {

        }
    }

    SQLiteDatabase database = this.getWritableDatabase();
              String projection[] = {"WORD"};
         Cursor c = database.query("WORD_TABLE",projection,null,null,null,null,null);


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}