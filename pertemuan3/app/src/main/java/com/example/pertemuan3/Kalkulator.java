package com.example.pertemuan3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Kalkulator extends AppCompatActivity {
    EditText num1,num2;
    TextView result;
    Button tomboltambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator);

        num1=(EditText) findViewById(R.id.angka1);
        num2=(EditText) findViewById(R.id.angka2);
        result=(TextView) findViewById(R.id.hasilHitung);
        tomboltambah=(Button) findViewById(R.id.tombolHitung);

        tomboltambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int angka1 = Integer.parseInt(num1.getText().toString());
                int angka2 = Integer.parseInt(num2.getText().toString());
                Integer hasil = angka1 + angka2;

                result.setText(hasil.toString());
            }
        });
    }

//    public void hitung(View view) {
//        int angka1 = Integer.parseInt(num1.getText().toString());
//        int angka2 = Integer.parseInt(num2.getText().toString());
//        Integer hasil = angka1 + angka2;
//        result.setText(hasil.toString());
//    }
}