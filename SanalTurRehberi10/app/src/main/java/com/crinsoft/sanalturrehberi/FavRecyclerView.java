package com.crinsoft.sanalturrehberi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FavRecyclerView extends RecyclerView.Adapter<FavRecyclerView.FavViewHolder>  {
    private ArrayList<FavBilgileri> mList = new ArrayList<>();

    public FavRecyclerView(ArrayList<FavBilgileri> mList){
        this.mList = mList;

    }

    @NonNull
    @Override
    public FavRecyclerView.FavViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tur_mekanlari_list, parent, false);
        return  new FavRecyclerView.FavViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FavRecyclerView.FavViewHolder holder, int position) {
        holder.menuTeXT.setText(mList.get(position).getMekanIsimleri());
    }

    @Override
    public int getItemCount() {
       return mList.size() ;
    }

    public class FavViewHolder extends RecyclerView.ViewHolder {
        public TextView menuTeXT;
        public CardView cardView;
        public TextView MekanAciklamasi;
        public FavViewHolder( View itemView) {
            super(itemView);
            menuTeXT=itemView.findViewById(R.id.favIsmi);
        }
    }
}
