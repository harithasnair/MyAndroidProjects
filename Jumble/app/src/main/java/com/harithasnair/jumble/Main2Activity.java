package com.harithasnair.jumble;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;
import android.widget.Toast;
import java.util.ArrayList;

import javax.xml.datatype.Duration;

public class Main2Activity extends AppCompatActivity {

    private static final String TAG = Main2Activity.class.getSimpleName();

    private TextView scramble;
    public TextView wordOne;
    public TextView wordTwo;
    public TextView wordThree;
    public TextView wordFour;
    private EditText editOne;
    private EditText editTwo;
    private EditText editThree;
    private EditText editFour;
    private Button submit;
    private Button giveup;
    private Button val1;
    private Button val2;
    private Button val3;
    private Button val4;
    private Button m1;
    private Button m2;
    private Button m3;
    private Button m4;

//    private TextView count;


    ArrayList<String> answers = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


         /* Defining Audio Variables*/
        final MediaPlayer jumble_One = MediaPlayer.create(this, R.raw.jumble_01);
        final MediaPlayer jumble_Two = MediaPlayer.create(this, R.raw.jumble_02);
        final MediaPlayer jumble_Three = MediaPlayer.create(this, R.raw.jumble_03);
        final MediaPlayer jumble_Four = MediaPlayer.create(this, R.raw.jumble_04);


        /*Initialising UI widgets*/
//      count = (TextView) findViewById(R.id.tv);
        wordOne = (TextView) findViewById(R.id.tv_01);
        wordTwo = (TextView) findViewById(R.id.tv_02);
        wordThree = (TextView) findViewById(R.id.tv_03);
        wordFour = (TextView) findViewById(R.id.tv_04);
        scramble = (TextView) findViewById(R.id.tv_scramble);
        editOne = (EditText) findViewById(R.id.et_01);
        editTwo = (EditText) findViewById(R.id.et_02);
        editThree = (EditText) findViewById(R.id.et_03);
        editFour = (EditText) findViewById(R.id.et_04);
        submit = (Button) findViewById(R.id.submit_button);
        giveup = (Button) findViewById(R.id.give_up);



        /* Setting Timer
        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                count.setText((int) (millisUntilFinished / 1000));
            }

            public void onFinish() {
                count.setText("Time Up!");
                jumble_One.start();
            }
        }.start(); */


        /* Initialising the validate Button and invoking validate methods*/
        val1 = (Button) findViewById(R.id.val_1);
        val1.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if (v == val1) {
                                            validate1();
                                            }
                                        }
                                    }
        );


        /* Initialising the meaning Button and invoking audio */
        m1 = (Button) findViewById(R.id.m_01);
        m1.setVisibility(View.INVISIBLE);
        m1.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {

                                      if (v == m1) {
                                          jumble_One.start();
                                      }
                                  }
                              }
        );

        /* Initialising the validate Button and invoking validate methods*/
        val2 = (Button) findViewById(R.id.val_2);
        val2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if (v == val2) {
                                            validate2();

                                        }
                                    }
                                }
        );

        /* Initialising the meaning Button and invoking audio */
        m2 = (Button) findViewById(R.id.m_02);
        m2.setVisibility(View.INVISIBLE);
        m2.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {

                                      if (v == m2) {
                                          jumble_Two.start();
                                      }
                                  }
                              }
        );

        /* Initialising the validate Button and invoking validate methods*/
        val3 = (Button) findViewById(R.id.val_3);
        val3.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if (v == val3) {
                                            validate3();
                                        }
                                    }
                                }
        );

        /* Initialising the meaning Button and invoking audio */
        m3 = (Button) findViewById(R.id.m_03);
        m3.setVisibility(View.INVISIBLE);
        m3.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {

                                      if (v == m3) {
                                          jumble_Three.start();
                                      }
                                  }
                              }
        );

        /* Initialising the validate Button and invoking validate methods*/
        val4 = (Button) findViewById(R.id.val_4);
        val4.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if (v == val4) {
                                            validate4();
                                        }
                                    }
                                }
        );

        /* Initialising the meaning Button and invoking audio */
        m4 = (Button) findViewById(R.id.m_04);
        m4.setVisibility(View.INVISIBLE);
        m4.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {

                                      if (v == m4) {
                                          jumble_Four.start();
                                      }
                                  }
                              }
        );


     /* Setting intent on clicking submit Button*/
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Main2Activity.this, Main3Activity.class);
                startActivity(intent2);
            }
        });


        /* Setting intent on clicking give up Button*/
        giveup.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {


                                              m1.setVisibility(View.VISIBLE);
                                              m2.setVisibility(View.VISIBLE);
                                              m3.setVisibility(View.VISIBLE);

                                              m4.setVisibility(View.VISIBLE);
                                          }
                                  });


        Log.d(TAG, "In MainActivity 2");

        ArrayList<TextView> words = new ArrayList<TextView>();
        words.add(wordOne);
        words.add(wordTwo);
        words.add(wordThree);
        words.add(wordFour);


        Log.d(TAG, "DONE DONE DONE");


        JSONTask process = new JSONTask();
        process.onPreExecute(words, answers);
        process.execute();

    }


    /*validate Method Body*/
    private void validate1() {

        String w1 = editOne.getText().toString();
        if ((answers.get(0).toLowerCase()).equals(w1.toLowerCase())) {

            Toast.makeText(this, "Congratulations! You found the First Word " + " " + answers.get(0), Toast.LENGTH_SHORT).show();
            m1.setVisibility(View.VISIBLE);
        }
        else {
            Toast.makeText(this, "Oops try again!", Toast.LENGTH_SHORT).show();
            editOne.setText("");

        }
        Log.d(TAG, w1.toLowerCase());

    }



    /*validate Method Body*/
    private void validate2() {
        String w2 = editTwo.getText().toString();
        if ((answers.get(1).toLowerCase()).equals(w2.toLowerCase())) {
            Toast.makeText(this, "Congratulations! You found the Second  Word" + " " + answers.get(1), Toast.LENGTH_SHORT).show();
            m2.setVisibility(View.VISIBLE);
        } else {
            Toast.makeText(this, "Oops try again!", Toast.LENGTH_SHORT).show();
           editTwo.setText("");
        }
    }

    /*validate Method Body*/
    private void validate3() {
        String w3 = editThree.getText().toString();
        if ((answers.get(2).toLowerCase()).equals(w3.toLowerCase())) {
            Toast.makeText(this, "Congratulations! You found the Third  Word" + " " + answers.get(2), Toast.LENGTH_SHORT).show();
            m3.setVisibility(View.VISIBLE);
        } else {
            Toast.makeText(this, "Oops try again!", Toast.LENGTH_SHORT).show();
           editThree.setText("");
        }
    }

    /*validate Method Body*/
    private void validate4() {
        String w4 = editFour.getText().toString();
        if ((answers.get(3).toLowerCase()).equals(w4.toLowerCase())) {
            Toast.makeText(this, "Congratulations! You found the Fourth  Word" + " " + answers.get(3), Toast.LENGTH_SHORT).show();
            m4.setVisibility(View.VISIBLE);
        } else {
            Toast.makeText(this, "Oops try again!", Toast.LENGTH_SHORT).show();
            editFour.setText("");
        }
    }
}














