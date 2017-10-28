package com.smile.mohamed.broadcastreceivertutorial;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class PermissionBroadcastActivity extends AppCompatActivity {

    private static final String ACTION_PERMISSION_TEST =
            "com.smile.mohamed.broadcastreceivertutorial.ACTION_PERMISSION_TEST";
    private String requiredPermission =
            "com.smile.mohamed.broadcastreceivertutorial.PERMISSION_FROM_ME";
    private IntentFilter filter;
    private PermissionBroadcast receiver;

    private static final String TAG = "mohamed";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_permission_broadcast);

//        create receiver and filter
        receiver = new PermissionBroadcast();
        filter = new IntentFilter(ACTION_PERMISSION_TEST);
//        send the broadcast
        Button buttonStartPermissionService = (Button) findViewById(R.id.buttonPermission);
        buttonStartPermissionService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Sending permission broadcast");
                Intent intentBroadcastPermission = new Intent(ACTION_PERMISSION_TEST);
                sendBroadcast(intentBroadcastPermission, requiredPermission);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Registering permission receiver");
        registerReceiver(receiver, filter, requiredPermission, null);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Unregistering permission receiver");
        unregisterReceiver(receiver);
    }
}
