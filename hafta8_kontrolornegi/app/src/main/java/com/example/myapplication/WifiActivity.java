package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WifiActivity extends AppCompatActivity {

    WifiManager wifiManager;
    Button btnac,btnkapat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_wifi);

        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        btnac= findViewById(R.id.btn_wac);
        btnkapat=findViewById(R.id.btn_wkapat);

        btnac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    Intent panelIntent = new Intent(Settings.Panel.ACTION_WIFI);
                    startActivityForResult(panelIntent, 1);
                } else {
                    wifiManager.setWifiEnabled(true);
                }
                Toast.makeText(WifiActivity.this, "Wi-Fi Paneli Açılıyor", Toast.LENGTH_SHORT).show();
            }
        });
        btnkapat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    Intent panelIntent = new Intent(Settings.Panel.ACTION_WIFI);
                    startActivityForResult(panelIntent, 1);
                } else {
                    wifiManager.setWifiEnabled(false);
                }
                Toast.makeText(WifiActivity.this, "Wi-Fi Paneli Açılıyor", Toast.LENGTH_SHORT).show();
            }
        });
    }
}