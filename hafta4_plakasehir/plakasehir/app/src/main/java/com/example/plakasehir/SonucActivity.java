package com.example.plakasehir;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SonucActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sonuc);

        TextView tvSonuc = findViewById(R.id.txt_snc);
        Button btnGeri = findViewById(R.id.btn_snc);


        boolean sonuc = getIntent().getBooleanExtra("durum", false);

        if (sonuc) {
            tvSonuc.setText("TEBRİKLER!\nEşleşme Doğru.");
            tvSonuc.setTextColor(Color.GREEN);
        } else {
            tvSonuc.setText("MAALESEF!\nEşleşme Yanlış.");
            tvSonuc.setTextColor(Color.RED);
        }

        // Geri dön butonu
        btnGeri.setOnClickListener(v -> finish());
    }
}