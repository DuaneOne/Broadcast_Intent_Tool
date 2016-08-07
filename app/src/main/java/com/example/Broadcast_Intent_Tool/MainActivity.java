package com.example.Broadcast_Intent_Tool;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

/* Broacast intent sender and receiver tool to help debug Mooshimeter send broadcast
and/or Tasker receiver. This was modified slightly from a Tutorials point example.
http://www.tutorialspoint.com/android/android_broadcast_receivers.htm*/

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    // broadcast a custom intent.
    public void broadcastIntent(View view){
        Intent intent = new Intent();
        //intent.setAction("com.tutorialspoint.CUSTOM_INTENT");
        intent.setAction("com.mooshim.mooshimeter.CUSTOM_INTENT");
        intent.putExtra("val", "3.14159");
        sendBroadcast(intent);
    }
}