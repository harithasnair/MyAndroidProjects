package com.harithasnair.mycustomintentbr;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private BroadcastReceiver broadcastReceiver;
    private Button broadcastIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        broadcastIntent = (Button) findViewById(R.id.bt_BR);
        broadcastReceiver = new MyBroadCastReceiver();

       broadcastIntent.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
               //To Trigger the Broadcast//
               Intent intent = new Intent();
                     intent.addCategory(Intent.CATEGORY_DEFAULT);
                       intent.setAction("my.custom.action.demo");
                       sendBroadcast(intent);
               Log.d(TAG,"msg sent");
           }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
