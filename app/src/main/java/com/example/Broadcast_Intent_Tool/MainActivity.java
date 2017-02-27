package com.example.Broadcast_Intent_Tool;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;


/* Broadcast intent sender and receiver tool to help debug Mooshimeter send broadcast
and/or Tasker receiver. This was modified from a Tutorials point example.
http://www.tutorialspoint.com/android/android_broadcast_receivers.htm*/

public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyReceiver.mainActivity = this;
    }
    @Override
    public void onResume() {
        super.onResume();
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    public void displayReceivedValues(String inString, Context context){
        TextView tv = (TextView)findViewById(R.id.textView1);
        tv.setText(inString);
    }


    // broadcast a custom intent in the same format that the mooshimeter app would except
    // send only ch1 value, just for testing
    public void broadcastIntent(View view){
        Intent intent = new Intent();
        intent.setAction("com.mooshim.mooshimeter.CH");
        intent.putExtra("value1", Float.valueOf("3.14159") );
        sendBroadcast(intent);
    }

}