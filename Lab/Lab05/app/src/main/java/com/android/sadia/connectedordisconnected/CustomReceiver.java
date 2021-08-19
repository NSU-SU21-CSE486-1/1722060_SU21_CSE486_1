package com.android.sadia.connectedordisconnected;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {
    boolean Headset_Plugged_in = false;

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        int extraMessage;

        if (Intent.ACTION_HEADSET_PLUG.equals(intentAction)) {
            extraMessage = intent.getIntExtra("state", -1);
            String toastMessage;

            switch(extraMessage){
                case 0:
                    Headset_Plugged_in = false;
                    toastMessage = "Headset Disconnected!";
                    break;

                case 1:
                    Headset_Plugged_in = true;
                    toastMessage = "Headset Connected!";
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + extraMessage);
            }
            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
        }

    }
}

