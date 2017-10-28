package com.smile.mohamed.broadcastreceivertutorial;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by COMPUMAGIC on 28/10/2017.
 */

public class PermissionBroadcast extends BroadcastReceiver {
    private static final String KEY_SERVICE_TYPE = "type_service";

    private static final String TAG = "mohamed";

    //    on receipt of broadcast, starts the permission service
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "Permission broadcast received");
        Intent intentStartPermissionService = new Intent(context,
                MySimpleService.class);
        intentStartPermissionService.putExtra(KEY_SERVICE_TYPE, 3);
        context.startService(intentStartPermissionService);
    }
}
