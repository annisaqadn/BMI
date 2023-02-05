package com.example.imt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String valueBB;
    String valueTB;
    EditText bb;
    EditText tb;
    Button hitung;
    double BBangka;
    double TBangka;
    double hasilIMT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bb = findViewById(R.id.beratbadan);
        tb = findViewById(R.id.tinggibadan);
        hitung = findViewById(R.id.bHitung);

        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valueBB = bb.getText().toString();
                valueTB = tb.getText().toString();

                if(valueBB.isEmpty() && valueTB.isEmpty()){
                    Toast.makeText(MainActivity.this,"Silahkan masukkan data anda!", Toast.LENGTH_LONG).show();
                }else if (valueBB.isEmpty()){
                    bb.setError("Halo guys, jangan lupa berat badanmu belum diisi lho!");
                }else if (valueTB.isEmpty()){
                    tb.setError("Halo guys, jangan lupa tinggi badanmu belum diisi lho!");
                }else{
                    BBangka = Double.parseDouble(valueBB);
                    TBangka = Double.parseDouble(valueTB);

                    hasilIMT = BBangka / ((TBangka/100) * (TBangka/100));

                    if (hasilIMT<17){
                        Intent i = new Intent(MainActivity.this, ktb.class);
                        startActivity(i);
                    } else if (hasilIMT>=17 && hasilIMT<18.4) {
                        Intent i = new Intent(MainActivity.this, ktr.class);
                        startActivity(i);
                    } else if (hasilIMT>=18.5 && hasilIMT<25) {
                        Intent i = new Intent(MainActivity.this, n.class);
                        startActivity(i);
                    } else if (hasilIMT>=25.1 && hasilIMT<=27) {
                        Intent i = new Intent(MainActivity.this, gtr.class);
                        startActivity(i);
                    } else{
                        Intent i = new Intent(MainActivity.this, gtb.class);
                        startActivity(i);
                    }
                }
            }
        });
    }
}