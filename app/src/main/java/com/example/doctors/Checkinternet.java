package com.example.doctors;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;


public class Checkinternet extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
            boolean noconnection = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);
            if (noconnection) {
                Toast.makeText(context, "No internet", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "connected to internet", Toast.LENGTH_SHORT).show();
            }

        }
    }}
