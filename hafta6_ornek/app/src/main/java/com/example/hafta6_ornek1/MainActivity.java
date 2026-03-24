package com.example.hafta6_ornek1;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button buton1,buton2,buton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        buton1 = findViewById(R.id.btn1);
        buton2 = findViewById(R.id.btn2);
        buton3 = findViewById(R.id.btn3);

        buton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder pencere = new AlertDialog.Builder(MainActivity.this);
                pencere.setTitle("UYARI!!");
                pencere.setMessage("Mesaj metni buraya yazılacak...");
                pencere.setCancelable(false);
                pencere.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"evete tıkladınız",Toast.LENGTH_SHORT).show();
                    }
                });
                pencere.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"hayıra tıkladınız",Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog goster=pencere.create();
                goster.show();
            }
        });

        AlertDialog.Builder uyari1 = new AlertDialog.Builder(MainActivity.this);
        uyari1.setTitle("Mesaj Başlığı");
        uyari1.setIcon(R.drawable.images);
        CharSequence[] items={"gs","fb","bjk"};
        uyari1.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), items[which], Toast.LENGTH_SHORT).show();
            }
        });
        buton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uyari1.show();
            }
        });

        ProgressDialog progress = new ProgressDialog(MainActivity.this);
        progress.setCancelable(true);
        progress.setTitle("mesaj başlığı");
        progress.setMessage("yükleniyor...");
        buton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress.show();
                Toast.makeText(getApplicationContext(), "işlem gerçekleşti", Toast.LENGTH_SHORT).show();
                try {
                    Thread.sleep(5000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}