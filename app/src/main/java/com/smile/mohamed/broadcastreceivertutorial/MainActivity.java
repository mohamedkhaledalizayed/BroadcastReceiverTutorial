package com.smile.mohamed.broadcastreceivertutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button btn_1,btn_2;
    private static final String KEY_SERVICE_TYPE = "type_service";
    private static final String TAG = "mohamed";
    private String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.text);
        btn_1=(Button)findViewById(R.id.btn_1);
        btn_2=(Button)findViewById(R.id.btn_2);
        textView.setText(getIntent().getStringExtra("message"));

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,LocalBroadcastActivity.class));
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,PermissionBroadcastActivity.class));
            }
        });

        int serviceType = getIntent().getIntExtra(KEY_SERVICE_TYPE, -1);
        switch (serviceType) {
            case -1:
                Log.i(TAG, "Service finished - You have a problem!");
                message = "There is a problem!";
                break;
            case 0:
//                unused
                break;
            case 1:
//                unused
                break;
            case 2:
//             /*   coming from ThirdActivity - local broadcast
                Log.i(TAG, "Service finished - Local Broadcast");
                //            stop the service
                Intent stopLocalService = new Intent(MainActivity.this,
                        MySimpleService.class);
                stopService(stopLocalService);
                message = "Local Broadcast intent received and processed";
                break;
            case 3:
//                coming from SecondActivity - permission broadcast
                Log.i(TAG, "Service finished - Permission Broadcast");
                //            stop the service
                Intent stopPermissionService = new Intent(MainActivity.this, MySimpleService.class);
                stopService(stopPermissionService);
                message = "Permission Broadcast intent received and processed";
                break;
        }
    }
}
