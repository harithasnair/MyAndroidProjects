package com.harithasnair.mybroadcastreciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BroadCastReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Broadcast receiver Message Triggered!",Toast.LENGTH_LONG).show();
    }
}
