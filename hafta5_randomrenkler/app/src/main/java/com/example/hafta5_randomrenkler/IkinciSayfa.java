package com.example.hafta5_randomrenkler;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class IkinciSayfa extends AppCompatActivity {

    public int sayac;
    public Handler handler = new Handler();
    TextView text;
    ConstraintLayout arkaplan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ikinci_sayfa);

        text=findViewById(R.id.txt_bilgi);
        arkaplan=findViewById(R.id.arkaplan);

        sayac = getIntent().getIntExtra("sonuc", 0);
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (sayac > 0) {
                    Random r = new Random();
                    int renk = Color.rgb(r.nextInt(256), r.nextInt(256), r.nextInt(256));

                    arkaplan.setBackgroundColor(renk);
                    text.setText("Kalan: " + sayac + " sn");

                    sayac--;
                    handler.postDelayed(this, 1000);
                } else {
                    Toast.makeText(IkinciSayfa.this, "Program bitmiştir", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}