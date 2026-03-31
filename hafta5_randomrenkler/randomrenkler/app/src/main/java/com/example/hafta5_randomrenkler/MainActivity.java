package com.example.hafta5_randomrenkler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar1,seekBar2;
    Button buton;
    public int secilenMin = 0, secilenMax = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        seekBar1=findViewById(R.id.seekBar);
        seekBar2=findViewById(R.id.seekBar2);
        buton=findViewById(R.id.button);

        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBar.setMax(10);
                secilenMin=progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBar2.setMax(10);
                secilenMax=progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int baslangic = Math.min(secilenMin, secilenMax);
                int bitis = Math.max(secilenMin, secilenMax);

                Random r = new Random();
                int randomSayi = r.nextInt((bitis - baslangic) + 1) + baslangic;

                Intent intent = new Intent(MainActivity.this, IkinciSayfa.class);
                intent.putExtra("sonuc", randomSayi);
                startActivity(intent);
            }
        });
    }
}