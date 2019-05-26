package com.harithasnair.mycustomintentbr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyBroadCastReceiver extends BroadcastReceiver
{

    private static final String TAG = "MyBroadCastReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"BR is triggered",Toast.LENGTH_SHORT).show();
        Log.d(TAG,"display msg");
    }
}
