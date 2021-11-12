package com.example.aplikasimenumcd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView maMcd;
    private ArrayList<Mcd> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maMcd = findViewById(R.id.ma_mcd);
        maMcd.setHasFixedSize(true);

        list.addAll(McdData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        maMcd.setLayoutManager(new LinearLayoutManager(this));
        ListMcdAdapter listMcdAdapter = new ListMcdAdapter(list);
        maMcd.setAdapter(listMcdAdapter);

        listMcdAdapter.setOnItemClickCallback(new ListMcdAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Mcd mcd) {
                //showRecyclerList();
                Intent moveIntent = new Intent(MainActivity.this,DetailFoodMcd.class);
                moveIntent.putExtra(DetailFoodMcd.ITEM_EXTRA, mcd);
                startActivity(moveIntent);
            }
        });


//sampe siniiiii

    }
}