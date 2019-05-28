package com.harithasnair.anagram_sqlite;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private TextView anagram;
    private Button nextButton;

    DatabaseHelperClass mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anagram = (TextView) (findViewById(R.id.tv_01));
        nextButton = (Button) findViewById(R.id.play_button);
//
//        mydb = new DatabaseHelperClass(this);

        // insert data
//        SQLiteDatabase database = mydb.getWritableDatabase();
//        String projection[] = {"ToBeSolvedWords"};
//        Cursor c = database.query("wordsTable",projection,null,null,null,null,null);
//
//        ContentValues values = new ContentValues();

        // Implementing HashMap

////        values.put("ToBeSolvedWords", "CAMERA");
//        values.put("ToBeSolvedWords","BRISK");
//          values.put("ToBeSolvedWords", "POTENT");
//        values.put("ToBeSolvedWords","CHEESY");
//        values.put("ToBeSolvedWords", "NINTH");
//        values.put("ToBeSolvedWords","BLEND");
//        values.put("ToBeSolvedWords", "AVOID");
//        values.put("ToBeSolvedWords","GASSY");
//        values.put("ToBeSolvedWords", "KHAKI");
//        values.put("ToBeSolvedWords","BANANA");
//        values.put("ToBeSolvedWords", "STOMP");
//        values.put("ToBeSolvedWords","CHILD");
//        values.put("ToBeSolvedWords", "DENOTE");
//        values.put("ToBeSolvedWords","TALLER");
//        values.put("ToBeSolvedWords", "FANCY");
//        values.put("ToBeSolvedWords","TUGGED");
//        values.put("ToBeSolvedWords", "EMBARK");
//        values.put("ToBeSolvedWords","REMOVE");
//        values.put("ToBeSolvedWords", "BLOOM");
//        values.put("ToBeSolvedWords","WAFER");
//        long row =  database.insert("wordsTable ","null",values);
//          System.out.println("row number :" +row);


//        SQLiteDatabase database = mydb.getReadableDatabase();


//        Cursor c = database.query("wordsTable", projection, null, null, null, null, null);

//         System.out.println("word is :" +c.getString(1));
//

//        ArrayList<String> data = new ArrayList<>();
//        if (c.moveToFirst()) {
//            data.add(c.getString(c.getColumnIndex(COL_2)));
//            while (c.moveToNext()) {
//                data.add(c.getString(c.getColumnIndex(COL_2)));
//            }
//        }
//
//        System.out.println("list of words is :" + data);
//        anagram.setText(data.get(0));
//
//         System.out.println("list of words is :" + anagram);
//
//
//////        c.close();
//////      database.close();
    }
}


