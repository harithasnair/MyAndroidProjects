package com.harithasnair.jumble_app;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static android.widget.Toast.*;

public class Main2Activity extends AppCompatActivity {
    private static final String TAG = Main2Activity.class.getSimpleName();
    private TextView scramble;
    public TextView wordOne;
    public TextView wordTwo;
    public  TextView wordThree;
    public TextView wordFour;
    private EditText editOne;
    private EditText editTwo;
    private EditText editThree;
    private EditText editFour;
    private Button submit;
    String shuffleWord1;
    String shuffleWord2;
    String shuffleWord3;
    String shuffleWord4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        wordOne = (TextView) findViewById(R.id.tv_01);
        wordTwo = (TextView) findViewById(R.id.tv_02);
        wordThree = (TextView) findViewById(R.id.tv_03);
        wordFour = (TextView) findViewById(R.id.tv_04);
        scramble = (TextView) findViewById(R.id.tv_scramble);
        editOne = (EditText)  findViewById(R.id.et_01);
        editTwo = (EditText) findViewById(R.id.et_02);
        editThree = (EditText) findViewById(R.id.et_03);
        editFour = (EditText) findViewById(R.id.et_04);
        submit = (Button) findViewById(R.id.submit_button);


    }


public class JSONTask extends AsyncTask<URL,String,String> {
    private final String TAG = JSONTask.class.getSimpleName();


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(URL... urls) {
        Log.d(TAG, "Aum Amriteswarei Namaha");
        URL url = null;
        try {
            url = new URL("https://api.myjson.com/bins/ecoa2");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream stream = connection.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            StringBuffer buffer = new StringBuffer();
            String line = "";

            JSONArray parentArray = new JSONArray();
            while ((line = reader.readLine()) != null) {
                buffer.append(line);

                String finalJson = buffer.toString();
                JSONObject parentObject = new JSONObject(finalJson);
                parentArray = parentObject.getJSONArray("clues");
            }

            Log.d(TAG, "This is" + parentArray.toString());


            for (int i = 0; i < parentArray.length(); i++) {
                JSONObject finalObject = parentArray.getJSONObject(i);

                if (i == 0) {
                   shuffleWord1 = finalObject.getString("j1");
                    wordOne.setText(shuffleWord1);
                    Log.d(TAG, finalObject.getString("j1"));
                } else if (i == 1) {
                    shuffleWord2 = finalObject.getString("j2");
                   wordTwo.setText(shuffleWord2);
                    Log.d(TAG, finalObject.getString("j2"));
                } else if (i == 2) {
                    shuffleWord3 = finalObject.getString("j3");
                    wordThree.setText(shuffleWord3);
                    Log.d(TAG, finalObject.getString("j3"));
                } else if (i == 3) {
                    shuffleWord4= finalObject.getString("j4");
                    wordFour.setText(shuffleWord4);
                    Log.d(TAG, finalObject.getString("j4"));
                } else
                    continue;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.d(TAG,"DONE");
        /*wordOne.setText(shuffleWord1);
        wordTwo.setText(shuffleWord2);
        wordThree.setText(shuffleWord3);
        wordFour.setText(shuffleWord4);*/

    }
}
}



