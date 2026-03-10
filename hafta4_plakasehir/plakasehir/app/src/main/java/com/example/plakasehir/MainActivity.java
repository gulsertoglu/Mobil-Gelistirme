package com.example.plakasehir;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    ListView lvPlakalar, lvSehirler;
    ArrayList<String> sehirListesi;
    ArrayList<String> plakaListesi;


    String[][] sehirPlakaTablosu = {
            {"Adana", "01"}, {"Adıyaman", "02"}, {"Afyonkarahisar", "03"}, {"Ağrı", "04"}, {"Amasya", "05"}, {"Ankara", "06"}, {"Antalya", "07"}, {"Artvin", "08"}, {"Aydın", "09"}, {"Balıkesir", "10"},
            {"Bilecik", "11"}, {"Bingöl", "12"}, {"Bitlis", "13"}, {"Bolu", "14"}, {"Burdur", "15"}, {"Bursa", "16"}, {"Çanakkale", "17"}, {"Çankırı", "18"}, {"Çorum", "19"}, {"Denizli", "20"},
            {"Diyarbakır", "21"}, {"Edirne", "22"}, {"Elazığ", "23"}, {"Erzincan", "24"}, {"Erzurum", "25"}, {"Eskişehir", "26"}, {"Gaziantep", "27"}, {"Giresun", "28"}, {"Gümüşhane", "29"}, {"Hakkari", "30"},
            {"Hatay", "31"}, {"Isparta", "32"}, {"Mersin", "33"}, {"İstanbul", "34"}, {"İzmir", "35"}, {"Kars", "36"}, {"Kastamonu", "37"}, {"Kayseri", "38"}, {"Kırklareli", "39"}, {"Kırşehir", "40"},
            {"Kocaeli", "41"}, {"Konya", "42"}, {"Kütahya", "43"}, {"Malatya", "44"}, {"Manisa", "45"}, {"Kahramanmaraş", "46"}, {"Mardin", "47"}, {"Muğla", "48"}, {"Muş", "49"}, {"Nevşehir", "50"},
            {"Niğde", "51"}, {"Ordu", "52"}, {"Rize", "53"}, {"Sakarya", "54"}, {"Samsun", "55"}, {"Siirt", "56"}, {"Sinop", "57"}, {"Sivas", "58"}, {"Tekirdağ", "59"}, {"Tokat", "60"},
            {"Trabzon", "61"}, {"Tunceli", "62"}, {"Şanlıurfa", "63"}, {"Uşak", "64"}, {"Van", "65"}, {"Yozgat", "66"}, {"Zonguldak", "67"}, {"Aksaray", "68"}, {"Bayburt", "69"}, {"Karaman", "70"},
            {"Kırıkkale", "71"}, {"Batman", "72"}, {"Şırnak", "73"}, {"Bartın", "74"}, {"Ardahan", "75"}, {"Iğdır", "76"}, {"Yalova", "77"}, {"Karabük", "78"}, {"Kilis", "79"}, {"Osmaniye", "80"}, {"Düzce", "81"}
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        lvPlakalar = findViewById(R.id.plakalar);
        lvSehirler = findViewById(R.id.sehirler);

        // Listeleri hazırla
        sehirListesi = new ArrayList<>();
        plakaListesi = new ArrayList<>();

        for (String[] satir : sehirPlakaTablosu) {
            sehirListesi.add(satir[0]);
        }


        for (int i = 1; i <= 81; i++) {
            if (i < 10) {
                plakaListesi.add("0" + i);
            } else {
                plakaListesi.add(String.valueOf(i));
            }
        }

        Collections.shuffle(plakaListesi);

        ArrayAdapter<String> plakaAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, plakaListesi);
        lvPlakalar.setAdapter(plakaAdapter);

        ArrayAdapter<String> adapterSehir = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sehirListesi);
        lvSehirler.setAdapter(adapterSehir);

        lvSehirler.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String tiklananSehir = sehirListesi.get(position);
                String oHizadakiPlaka = plakaListesi.get(position);


                boolean dogruMu = false;
                for (String[] veri : sehirPlakaTablosu) {
                    if (veri[0].equals(tiklananSehir) && veri[1].equals(oHizadakiPlaka)) {
                        dogruMu = true;
                        break;
                    }
                }

                // Sonuç sayfasına geçiş
                Intent intent = new Intent(MainActivity.this, SonucActivity.class);
                intent.putExtra("durum", dogruMu); // True veya False gönderiyoruz
                startActivity(intent);
            }
        });
    }
}