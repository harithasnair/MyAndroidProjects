package com.harithasnair.jumble;

import android.os.AsyncTask;

import com.harithasnair.answer.AnswerJsonParser;
import com.harithasnair.model.ModelJsonParser;
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
import java.util.ArrayList;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;



public class JSONTask extends AsyncTask<URL,String,String> {
        private static final String TAG = JSONTask.class.getSimpleName();

        ModelJsonParser model = new ModelJsonParser();
       AnswerJsonParser answer = new AnswerJsonParser();

        TextView wordOne;
        TextView wordTwo;
        TextView wordThree;
        TextView wordFour;
        EditText editOne;
        EditText editTwo;
        EditText editThree;
        EditText editFour;
    private String wordToFind1;
    private String wordToFind2;
    private String wordToFind3;
    private String wordToFind4;
    ArrayList<String>ans;


    protected void onPreExecute(ArrayList<TextView> words,ArrayList<String> answers) {
        super.onPreExecute();
        wordOne = words.get(0);
        wordTwo = words.get(1);
        wordThree = words.get(2);
        wordFour = words.get(3);
        ans = answers;
        Log.d(TAG,words.get(0).toString());
        Log.d(TAG,"In JSON preExecute 1");
   }


    //@Override
        protected String doInBackground(URL... urls)  {
            Log.d(TAG,  "Aum Amriteswarei Namaha");
            URL url = null;
            try {
                url = new URL("https://api.myjson.com/bins/sbxa0");
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
                        model.setWord1(finalObject.getString("j1"));
                        Log.d(TAG,finalObject.getString("j1"));
                    } else if (i == 1) {
                        model.setWord2(finalObject.getString("j2"));
                        Log.d(TAG,finalObject.getString("j2"));
                    } else if (i == 2) {
                        model.setWord3(finalObject.getString("j3"));
                        Log.d(TAG,finalObject.getString("j3"));
                    } else if (i == 3) {
                        model.setWord4(finalObject.getString("j4"));
                        Log.d(TAG,finalObject.getString("j4"));
                    } else
                        continue;
                }

                for (int i = 0; i < parentArray.length(); i++) {
                    JSONObject answerObject = parentArray.getJSONObject(i);
                    if (i == 0) {
                        answer.setWord1( answerObject.getString("ans1"));
                        Log.d(TAG,answerObject.getString("ans1"));
                    } else if (i == 1) {
                        answer.setWord2( answerObject.getString("ans2"));
                        Log.d(TAG,answerObject.getString("ans2"));
                    } else if (i == 2) {
                        answer.setWord3(answerObject.getString("ans3"));
                        Log.d(TAG,answerObject.getString("ans3"));
                    } else if (i == 3) {
                        answer.setWord4(answerObject.getString("ans4"));
                        Log.d(TAG,answerObject.getString("ans4"));
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


            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                Log.d(TAG,"JSON Task onPost");
                Log.d(TAG,wordOne.toString());
                wordOne.setText(model.getWord1());
                wordTwo.setText(model.getWord2());
                wordThree.setText(model.getWord3());
                wordFour.setText(model.getWord4());
                Log.d(TAG,"All fucked up!");

                wordToFind1 = answer.getWord1();
                wordToFind2 = answer.getWord2();
                wordToFind3 = answer.getWord3();
                wordToFind4 = answer.getWord4();

                ans.add(wordToFind1);
                ans.add(wordToFind2);
                ans.add(wordToFind3);
                ans.add(wordToFind4);

               // Log.d(TAG, wordToFind1.toLowerCase());
                Log.d(TAG,"All fucked up!");
                Log.d(TAG,"I got it!");
                // TextView wordOne = (TextView) Main2Activity.class.findViewById(R.id.tv_01);


            }

    }
