package com.smile.mohamed.broadcastreceivertutorial;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class LocalBroadcastActivity extends AppCompatActivity {

    private static final String ACTION_LOCAL_BROADCAST =
            "com.smile.mohamed.broadcastreceivertutorial.ACTION_LOCAL_BROADCAST";
    LocalBroadcast myLocalReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_broadcast);


        myLocalReceiver=new LocalBroadcast();
        LocalBroadcastManager.getInstance(this).registerReceiver(myLocalReceiver,
                new IntentFilter(ACTION_LOCAL_BROADCAST));

//        button starts the local broadcaster
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ACTION_LOCAL_BROADCAST);
                // include some extra data.
                intent.putExtra("message", "Local broadcast received");
                LocalBroadcastManager.getInstance(LocalBroadcastActivity.this)
                        .sendBroadcast(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this)
                .unregisterReceiver(myLocalReceiver);
    }

}
