package com.example.Broadcast_Intent_Tool;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;


public class MyReceiver extends BroadcastReceiver {

    public static MainActivity mainActivity;
    private static int count = 0;
    @Override


    public void onReceive(Context context, Intent intent) {
        Bundle RecExtras = intent.getExtras() ;
        // values are Floats , units are Strings
        String ch1v = String.valueOf( RecExtras.getFloat("value1") );
        String ch2v = String.valueOf( RecExtras.getFloat("value2") );
        String ch3v = String.valueOf( RecExtras.getFloat("value3") );
        String bat  = String.valueOf( RecExtras.getFloat("moobat") );

        String ch1u =  RecExtras.getString("units1") ;
        String ch2u =  RecExtras.getString("units2") ;
        String ch3u =  RecExtras.getString("units3") ;

        // \r\n puts next string on a new line
        String all = "CH1: " + ch1v + " " + ch1u + "\r\n" +
                     "CH2: " + ch2v + " " + ch2u + "\r\n" +
                     "CH3: " + ch3v + " " + ch3u + "\r\n" +
                     "BAT: " + bat;

        //display string in a existing text box
        mainActivity.displayReceivedValues(all, context);

        // new intents come quickly and overwhelm the popup, so
        // popup every nth occurrence
        count = count+1;
        if (count>= 9) {
            Toast.makeText(context, all, Toast.LENGTH_SHORT).show();
            count = 0;
        }

    }
}