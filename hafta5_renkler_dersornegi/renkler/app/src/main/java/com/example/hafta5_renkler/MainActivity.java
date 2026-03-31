package com.example.hafta5_renkler;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView tkirmizi,tyesil,tmavi;
    SeekBar skirmizi,syesil,smavi;
    ConstraintLayout arkaplan;
    public int oran1=0,oran2=0,oran3=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tkirmizi  = findViewById(R.id.txt_kirmizi);
        tyesil = findViewById(R.id.txt_yesil);
        tmavi = findViewById(R.id.txt_mavi);

        skirmizi = findViewById(R.id.seek_kirmizi);
        syesil=findViewById(R.id.seek_yesil);
        smavi=findViewById(R.id.seek_mavi);

        arkaplan=findViewById(R.id.arkaplan);

        skirmizi.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                skirmizi.setMax(255);
                int oran=android.graphics.Color.rgb(oran2,oran3,progress);
                arkaplan.setBackgroundColor(oran);
                tkirmizi.setText(String.valueOf(progress));
                oran1=progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        syesil.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                syesil.setMax(255);
                int oran=android.graphics.Color.rgb(oran1,oran3,progress);
                arkaplan.setBackgroundColor(oran);
                tyesil.setText(String.valueOf(progress));
                oran2=progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        smavi.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                smavi.setMax(255);
                int oran=android.graphics.Color.rgb(oran1,oran2,progress);
                arkaplan.setBackgroundColor(oran);
                tmavi.setText(String.valueOf(progress));
                oran3=progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}