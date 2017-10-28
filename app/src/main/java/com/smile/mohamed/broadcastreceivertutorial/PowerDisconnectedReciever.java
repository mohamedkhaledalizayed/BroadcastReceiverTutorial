package com.smile.mohamed.broadcastreceivertutorial;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by COMPUMAGIC on 28/10/2017.
 */

public class PowerDisconnectedReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intent1=new Intent(context,MainActivity.class);
        intent1.putExtra("message","Power got disconnected to the device.");
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent1);
    }
}
