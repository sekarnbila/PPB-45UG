package com.example.aplikasimenumcd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailFoodMcd extends AppCompatActivity {
    public static final String ITEM_EXTRA = "item_extra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_food_mcd);

        ImageView imgMcd = findViewById(R.id.imgMcd);
        TextView McdFoodName_Detail = findViewById(R.id.McdFoodName_Detail);
        TextView McdFoodDetail_Detail = findViewById(R.id.McdFoodDetail_Detail);
        TextView McdFoodPrice_Detail = findViewById(R.id.McdFoodPrice_Detail);

        Mcd mcd = getIntent().getParcelableExtra(ITEM_EXTRA);

        if (mcd != null) {
            Glide.with(this)
                    .load(mcd.getPhoto())
                    .into(imgMcd);
            McdFoodName_Detail.setText(mcd.getName());
            McdFoodDetail_Detail.setText(mcd.getDetail());
            McdFoodPrice_Detail.setText(mcd.getPrice());
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Detail Mcd");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}