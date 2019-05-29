package com.harithasnair.anagram_sqlite;
import android.database.Cursor;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;



public class MainActivity extends AppCompatActivity {

    private TextView anagram;
    private Button play;

    DatabaseHelperClass mydb;
    Cursor c = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anagram = (TextView) (findViewById(R.id.tv_01));
        play = (Button) findViewById(R.id.play_button);

        play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DatabaseHelperClass dbHelper = new DatabaseHelperClass(MainActivity.this);
                try {
                    dbHelper.createDataBase();
                } catch (IOException ioe) {
                    throw new Error("Unable to create database");
                }

                try {
                    dbHelper.openDataBase();
                } catch (SQLException sqle) {
                    throw sqle;
                }

                Toast.makeText(MainActivity.this, "Succesfully Imported", Toast.LENGTH_SHORT).show();
                c = dbHelper.query("table", null, null, null, null, null, null);
                if (c.moveToFirst()) {
                    do {
                        Toast.makeText(MainActivity.this, "WORD:" + c.getString(1), Toast.LENGTH_LONG).show();
                    } while (c.moveToNext());
                }
            }
        });
    }
}