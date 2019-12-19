package com.example.karan.smsservice;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText e1;
Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.editText);
        b1=findViewById(R.id.button);
        if (ActivityCompat.checkSelfPermission(this,Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) //runtime permission
        {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},1);
            return;
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
               String query = e1.getText().toString(); // edittext se msg get kiya jo humne bhejna hai
               String number = "8744985493"; // kis no. pe bhejna hai

                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage(number, null, query,null,null);
                Toast.makeText(MainActivity.this, "SMS sent...", Toast.LENGTH_SHORT).show();
                e1.setText("");
            }
        });
    }
}
