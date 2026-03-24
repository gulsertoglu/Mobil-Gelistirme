package com.example.hafta6_odev;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button buton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        buton= findViewById(R.id.btn1);
        int[] resimListesi = {
                R.drawable.ankara1, // Kendi dosya isimlerinizi yazın
                R.drawable.ankara2,
                R.drawable.ankara3,
                R.drawable.ist1,
                R.drawable.ist2,
                R.drawable.ist3,
                R.drawable.izmir1,
                R.drawable.izmir2,
                R.drawable.izmir3
        };
        Random random = new Random();
        int rastgeleIndeks = random.nextInt(resimListesi.length);
        AlertDialog.Builder uyari1 = new AlertDialog.Builder(MainActivity.this);
        uyari1.setTitle("Mesaj Başlığı");
        uyari1.setIcon(resimListesi[rastgeleIndeks]);
        CharSequence[] items={"İzmir","İstanbul","Ankara"};
        uyari1.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent;

                if (which == 0) { // İzmir seçildiyse
                    intent = new Intent(MainActivity.this, izmir.class);
                    startActivity(intent);
                }
                else if (which == 1) { // İstanbul seçildiyse
                    intent = new Intent(MainActivity.this, istanbul.class);
                    startActivity(intent);
                }
                else if (which == 2) { // Ankara seçildiyse
                    intent = new Intent(MainActivity.this, ankara.class);
                    startActivity(intent);
                }
            }
        });

        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uyari1.show();
            }
        });

    }
}