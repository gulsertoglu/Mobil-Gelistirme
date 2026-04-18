package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button bluetooth,wifi,kamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        bluetooth=findViewById(R.id.btn_bluetooth);
        wifi=findViewById(R.id.btn_wifi);
        kamera=findViewById(R.id.btn_camera);

        bluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bluetoothsayfa = new Intent(MainActivity.this,BluetoothActivity.class);
                startActivity(bluetoothsayfa);
            }
        });

        wifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent wifisayfa = new Intent(MainActivity.this,WifiActivity.class);
                startActivity(wifisayfa);
            }
        });

        kamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kamerasayfa = new Intent(MainActivity.this,CameraActivity.class);
                startActivity(kamerasayfa);
            }
        });
    }
}