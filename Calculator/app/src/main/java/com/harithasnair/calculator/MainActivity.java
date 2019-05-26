package com.harithasnair.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

   private Button one;
   private Button two;
   private Button three;
   private Button four;
   private Button five;
   private Button six;
   private Button seven;
   private Button eight;
   private Button nine;
   private Button zero;
   private Button clear;
   private Button add;
   private Button subtract;
   private Button div;
   private Button multiply;
   private Button equals;
   private TextView input;
   private TextView result;
   private final char ADDITION = '+';
   private final char SUBTRACTION = '-';
   private final char MULTIPLICATION = '*';
   private final char DIVISION = '/';
   private double var1 = Double.NaN;
   private double var2;
   private char ACTION;
   private final char EQUAL = '0';


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setUpUiViews();

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "3");
            }
        });


        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "5");
            }
        });

       six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "6");
            }
        });

       seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "9");
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ACTION = ADDITION;
                compute();
                result.setText(String.valueOf(var1) + "+");
                input.setText(null);
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ACTION = MULTIPLICATION;
                compute();
                result.setText(String.valueOf(var1) + "*");
                input.setText(null);
            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ACTION = SUBTRACTION;
                compute();
                result.setText(String.valueOf(var1) + "-");
                input.setText(null);
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = DIVISION;
                result.setText(String.valueOf(var1) + "/");
                input.setText(null);
            }
        });


        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ACTION = EQUAL;
                compute();
                result.setText(result.getText().toString() + String.valueOf(var2) + "=");
                input.setText(null);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().length() > 0){
                    CharSequence name = input.getText().toString();
                    input.setText(name.subSequence(0,name.length()-1));
                }
                else
                {

                    var1 = Double.NaN;
                    var2 = Double.NaN;
                    input.setText(null);
                    result.setText(null);
                }
            }
        });

    }

private void setUpUiViews() {
    one = (Button) findViewById(R.id.btn1);
    two = (Button) findViewById(R.id.btn2);
    three = (Button) findViewById(R.id.btn3);
    four = (Button) findViewById(R.id.btn4);
    five = (Button) findViewById(R.id.btn5);
    six = (Button) findViewById(R.id.btn6);
    seven = (Button) findViewById(R.id.btn7);
    eight = (Button) findViewById(R.id.btn8);
    nine = (Button) findViewById(R.id.btn9);
    zero = (Button) findViewById(R.id.btn0);
    clear = (Button) findViewById(R.id.btnclear);
    add = (Button) findViewById(R.id.btnadd);
    subtract = (Button) findViewById(R.id.btnsubtract);
    div = (Button) findViewById(R.id.btndivide);
    multiply = (Button) findViewById(R.id.btnmultiply);
    equals = (Button) findViewById(R.id.btnequals);
    input = (TextView) findViewById(R.id.txtvwinput);
    result = (TextView) findViewById(R.id.txtvwresult);
}

private void compute(){
        if(!Double.isNaN(var1)){
            var2 = Double.parseDouble(input.getText().toString());
            switch(ACTION){
                case ADDITION:
                var1 = var1 + var2;
                        break;

                case MULTIPLICATION:
                var1 = var1 * var2;
                break;

                case DIVISION:
                    var1 = var1 / var2;
                    break;

                case SUBTRACTION:
                    var1 = var1 - var2;
                    break;

                case EQUAL:
                    break;


            }
        }

        else
        {
            var1 = Double.parseDouble(input.getText().toString());

        }
}
}