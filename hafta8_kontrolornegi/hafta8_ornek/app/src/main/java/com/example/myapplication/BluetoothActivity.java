package com.example.myapplication;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.bluetooth.BluetoothDevice;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet; // Tedbir amaçlı kalsın

import java.util.Set;

public class BluetoothActivity extends AppCompatActivity {

    BluetoothAdapter adapter;
    Button btnac,btnkapat,btnlistele,btngorunur;
    ListView listView;

    ActivityResultLauncher<Intent> bluetoothLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Toast.makeText(this, "Bluetooth Açıldı", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Bluetooth açma reddedildi", Toast.LENGTH_SHORT).show();
                }
            }
    );


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bluetooth);

        adapter=BluetoothAdapter.getDefaultAdapter();

        btnac=findViewById(R.id.btn_ac);
        btngorunur=findViewById(R.id.btn_gorunur);
        btnkapat=findViewById(R.id.btn_kapat);
        btnlistele=findViewById(R.id.btn_listele);
        listView = findViewById(R.id.listview);


        btnac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (adapter == null) {
                    Toast.makeText(BluetoothActivity.this, "Cihazınız Bluetooth desteklemiyor", Toast.LENGTH_SHORT).show();
                } else if (!adapter.isEnabled()) {
                    Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    bluetoothLauncher.launch(intent);
                }
            }
        });
        btnkapat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (adapter != null && adapter.isEnabled()) {
                    try {
                        boolean success = adapter.disable();

                        if (success) {
                            Toast.makeText(BluetoothActivity.this, "Bluetooth Kapatıldı", Toast.LENGTH_SHORT).show();
                        } else {
                            Intent intent = new Intent(android.provider.Settings.ACTION_BLUETOOTH_SETTINGS);
                            startActivity(intent);
                            Toast.makeText(BluetoothActivity.this, "Lütfen ayarlardan kapatın", Toast.LENGTH_SHORT).show();
                        }
                    } catch (SecurityException e) {
                        Intent intent = new Intent(android.provider.Settings.ACTION_BLUETOOTH_SETTINGS);
                        startActivity(intent);
                    }
                }
            }
        });
        ArrayAdapter<String> adapterList;
        ArrayList<String> cihazIsimleri = new ArrayList<>();

        adapterList = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cihazIsimleri);
        listView.setAdapter(adapterList);

        btnlistele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (adapter != null && adapter.isEnabled()) {
                    // İzin Kontrolü (Kırmızılıkları önlemek için şart)
                    if (ActivityCompat.checkSelfPermission(BluetoothActivity.this, android.Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(BluetoothActivity.this, new String[]{android.Manifest.permission.BLUETOOTH_CONNECT}, 1);
                        return;
                    }

                    Set<BluetoothDevice> pairedDevices = adapter.getBondedDevices();
                    cihazIsimleri.clear(); // Listeyi temizle ki üst üste binmesin

                    if (pairedDevices.size() > 0) {
                        for (BluetoothDevice device : pairedDevices) {
                            cihazIsimleri.add(device.getName() + "\n" + device.getAddress());
                        }
                        adapterList.notifyDataSetChanged(); // Listeyi güncelle
                        Toast.makeText(BluetoothActivity.this, "Cihazlar Listelendi", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(BluetoothActivity.this, "Eşleşmiş cihaz bulunamadı", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btngorunur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(BluetoothActivity.this, android.Manifest.permission.BLUETOOTH_ADVERTISE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(BluetoothActivity.this, new String[]{android.Manifest.permission.BLUETOOTH_ADVERTISE}, 2);
                } else {
                    Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                    intent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 120);
                    startActivity(intent);
                }
            }
        });
    }
}