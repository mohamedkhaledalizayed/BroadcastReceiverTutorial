package com.smile.mohamed.broadcastreceivertutorial;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by COMPUMAGIC on 28/10/2017.
 */

public class LocalBroadcast extends BroadcastReceiver {
    private static final String KEY_SERVICE_TYPE = "type_service";

    @Override
    public void onReceive(Context context, Intent intent) {
        // Get extra data included in the Intent
        String message = intent.getStringExtra("message");
        //Log.i(TAG, "Got message: " + message);
        Intent intentStartService = new Intent(context,
                MySimpleService.class);
        intentStartService.putExtra(KEY_SERVICE_TYPE, 2);
        context.startService(intentStartService);
    }
}
