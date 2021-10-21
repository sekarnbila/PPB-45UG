package com.example.tugas_pertemuan4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Edit_Anime extends AppCompatActivity {

    DatabaseHelper databh;
    EditText cnomor,ctokoh,cttl,cpembuat,cnama;
    Button btnupdate,btndelete,btnview;

    String dnomor="nomornya";
    String dtokoh="tokohnya";
    String dttl="ttlnya";
    String dpembuat="pembuatnya";
    String dnama="namanya";

    String tampungNomor,tampungTokoh,tampungTtl,tampungPembuat,tampungNama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_anime);

        cnomor=findViewById(R.id.nomor_edit);
        ctokoh=findViewById(R.id.tokoh_edit);
        cttl=findViewById(R.id.ttltkh_edit);
        cpembuat=findViewById(R.id.pembuattkh_edit);
        cnama=findViewById(R.id.namaanime_edit);


        btnupdate=findViewById(R.id.tombol_update);
        btndelete=findViewById(R.id.tombol_delete);
        btnview=findViewById(R.id.tombol_view);

        databh=new DatabaseHelper(this);


        Bundle bundle=getIntent().getExtras();
        tampungNomor=bundle.getString(dnomor);
        tampungTokoh=bundle.getString(dtokoh);
        tampungTtl=bundle.getString(dttl);
        tampungPembuat=bundle.getString(dpembuat);
        tampungNama=bundle.getString(dnama);

        cnomor.setText(tampungNomor);
        ctokoh.setText(tampungTokoh);
        cttl.setText(tampungTtl);
        cpembuat.setText(tampungPembuat);
        cnama.setText(tampungNama);

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databh.update_data(cnomor.getText().toString(),ctokoh.getText().toString(),cttl.getText().toString(),cpembuat.getText().toString(),cnama.getText().toString());
                Toast.makeText(getApplicationContext(), "Update Sukses !", Toast.LENGTH_SHORT).show();
            }
        });

        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Edit_Anime.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databh.hapus_data(cnomor.getText().toString());
                Toast.makeText(getApplicationContext(), "Delete Suskes !", Toast.LENGTH_SHORT).show();
            }
        });


    }
}