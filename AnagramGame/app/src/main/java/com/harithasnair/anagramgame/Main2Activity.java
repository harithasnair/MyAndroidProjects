package com.harithasnair.anagramgame;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener
{

 private TextView word_tv;
 private EditText ans_ev;
 private Button validate_bt;
 private Button newGame_bt;
 private String wordToFind;

 @Override
 protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

 word_tv = (TextView)findViewById(R.id.tv_01);
 ans_ev = (EditText) findViewById(R.id.ev_01);
 validate_bt = (Button) findViewById(R.id.bt_validate);
 validate_bt.setOnClickListener(this);
 newGame_bt = (Button) findViewById(R.id.bt_ngame);
 newGame_bt.setOnClickListener(this);

 newGame();

 }
    @Override
    public void onClick(View v) {
        if (v == validate_bt) {
            validate();
        } else {
            if (v == newGame_bt) {
                newGame();

            }
        }
    }

    private void validate(){
        String w = ans_ev.getText().toString();
        if(wordToFind.equals(w)){
            Toast.makeText(this,"Congratulations! You found the Word"+" "+wordToFind, Toast.LENGTH_SHORT ).show();
            newGame();
        }
        else{
            Toast.makeText(this,"Oops try again!" ,Toast.LENGTH_SHORT).show();
        }
    }

    private void newGame(){
        wordToFind = Anagram.randomWord();
        String wordShuffled = Anagram.ShuffleWord(wordToFind);
        word_tv.setText(wordShuffled);
        ans_ev.setText("");

    }

}
