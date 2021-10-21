package com.example.tugas_pertemuan4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Input_Anime extends AppCompatActivity {
    Button tblsave,tblview;
    EditText xnomor,xtokoh_anime,xttl_anime,xpembuat_anime,xnama_anime;

    DatabaseHelper databh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_anime);


        xnomor=findViewById(R.id.nomor);
        xtokoh_anime=findViewById(R.id.tokoh);
        xttl_anime=findViewById(R.id.ttltkh);
        xpembuat_anime=findViewById(R.id.pembuattkh);
        xnama_anime=findViewById(R.id.namaanime);

        databh=new DatabaseHelper(this);

        tblview=findViewById(R.id.tombol_view);
        tblsave=findViewById(R.id.tombol_simpan);

        tblsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (xnomor.getText().length()<1 || xnomor.getText().length()>1 ) {
                    xnomor.setError("kurang atau lebih dari 1 karakter");
                    Toast.makeText(getApplicationContext(), "masukkan harus 1 karakter", Toast.LENGTH_SHORT).show();
                    xnomor.requestFocus();
                } else {
                    databh.tambah_data(xnomor.getText().toString(), xtokoh_anime.getText().toString(),xttl_anime.getText().toString(),xpembuat_anime.getText().toString(),xnama_anime.getText().toString());
                    Toast.makeText(getApplicationContext(), "Save Sukses!", Toast.LENGTH_SHORT).show();


                }


            }
        });

        tblview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Input_Anime.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}