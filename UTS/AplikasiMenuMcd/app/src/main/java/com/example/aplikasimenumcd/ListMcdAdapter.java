package com.example.aplikasimenumcd;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListMcdAdapter extends RecyclerView.Adapter<ListMcdAdapter.ListViewHolder>{
    private ArrayList<Mcd> listMcd;

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public ListMcdAdapter(ArrayList<Mcd> list) {
        this.listMcd = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_mcd,parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Mcd mcd = listMcd.get(position);
        Glide.with(holder.itemView.getContext())
                .load(mcd.getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.mcdPhoto);
        holder.mcdName.setText(mcd.getName());
        holder.mcdPrice.setText(mcd.getPrice());
        holder.mcdDetail.setText(mcd.getDetail());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(listMcd.get(holder.getAdapterPosition()));

            }
        });
    }

    @Override
    public int getItemCount() {
        return listMcd.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView mcdPhoto;
        TextView mcdName;
        TextView mcdPrice;
        TextView mcdDetail;

        public ListViewHolder(View itemview) {
            super(itemview);
            mcdPhoto = itemview.findViewById(R.id.imgcircleMCD);
            mcdName = itemview.findViewById(R.id.namefoodMCD);
            mcdPrice = itemview.findViewById(R.id.pricefoodMCD);
            mcdDetail = itemview.findViewById(R.id.detailfoodMCD);
        }
    }

    public interface OnItemClickCallback{
        void onItemClicked(Mcd data);
    }
}