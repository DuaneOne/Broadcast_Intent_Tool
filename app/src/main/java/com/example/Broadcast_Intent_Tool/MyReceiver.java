package com.example.Broadcast_Intent_Tool;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle RecExtras = intent.getExtras() ;
        String key1 = RecExtras.getString("val");
        Toast.makeText(context, "MyReceiver.  " + key1, Toast.LENGTH_LONG).show();
    }
}