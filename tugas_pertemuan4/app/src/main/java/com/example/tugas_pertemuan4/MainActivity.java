package com.example.tugas_pertemuan4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper databh;
    ListView listView;

    Button tblinput;

    ArrayList<String> listitem;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.list_data);

        databh=new DatabaseHelper(this);

        tblinput=findViewById(R.id.tombol_input);

        listitem=new ArrayList<>();

        final Cursor[] cursor = {databh.baca_data()};
        //Cursor cursor=databh.baca_data();

        //String nomor="1";
        //String tokoh_anime="Monkey D Luffy";
        //String ttl_anime="12 Desember 2002";
        //String pembuat_anime="Nabila";
        //String nama_anime="One Piece";

        //databh.tambah_data(nomor,tokoh_anime,ttl_anime,pembuat_anime,nama_anime);
        listitem.clear();

        while (cursor[0].moveToNext())
        {
            listitem.add(cursor[0].getString(0)+". "+cursor[0].getString(1)+" "+cursor[0].getString(2)+" "+cursor[0].getString(3)+" "+cursor[0].getString(4));
        }
        adapter=new ArrayAdapter(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,listitem);
        listView.setAdapter(adapter);

        tblinput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Input_Anime.class);
                startActivity(intent);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent=new Intent(MainActivity.this,Edit_Anime.class);

                final Cursor[] cursor = {databh.baca_data()};
                cursor[0].moveToPosition(position);
                String cnomor=cursor[0].getString(0);
                String ctokoh=cursor[0].getString(1);
                String cttl=cursor[0].getString(2);
                String cpembuat=cursor[0].getString(3);
                String cnama=cursor[0].getString(4);
                Toast.makeText(getApplicationContext(),ctokoh, Toast.LENGTH_SHORT).show();

                String mnomor=(listitem.get(position).substring(0,1));
                int panjang=listitem.get(position).length();
                String mtokoh=(listitem.get(position).substring(2,panjang));
                String mttl=(listitem.get(position).substring(2,panjang));
                String mpembuat=(listitem.get(position).substring(2,panjang));
                String mnama=(listitem.get(position).substring(2,panjang));

                intent.putExtra("nomornya",cnomor);
                intent.putExtra("tokohnya",ctokoh);
                intent.putExtra("ttlnya",cttl);
                intent.putExtra("pembuatnya",cpembuat);
                intent.putExtra("namanya",cnama);

                startActivity(intent);
                return false;
            }
        });
    }
}

