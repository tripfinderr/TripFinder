package com.crinsoft.sanalturrehberi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.RecViewHolder>   {
    private ArrayList<MekanBilgileri> mList = new ArrayList<>();
    private Context context;
    private String UserNickName;





    public ExampleAdapter(ArrayList<MekanBilgileri> mList,Context context,String UserNickName){
        this.mList = mList;
        this.context=context;
        this.UserNickName=UserNickName;


    }


    @NonNull
    @Override
    public RecViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tur_mekanlari_list, parent, false);
        return  new RecViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecViewHolder holder, final int position) {
        holder.menuTeXT.setText(mList.get(position).getMekanIsmi());
        holder.MekanAciklamasi.setText(mList.get(position).getMekanAciklamasi());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast toast = Toast.makeText(context,mList.get(position).getMekanIsmi(), Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.show();

                Intent intent = new Intent(context,MekanDetaylariActivity.class);
                intent.putExtra("mekanBilgisi",mList.get(position).getMekanIsmi());
                intent.putExtra("UserNickName",UserNickName);
                context.startActivity(intent);



            }
        });

    }

    public int getItemCount(){
        return mList.size();
    }

    public class RecViewHolder extends RecyclerView.ViewHolder  {

        public TextView menuTeXT;
        public CardView cardView;
        public TextView MekanAciklamasi;


        public RecViewHolder(View itemView){
            super(itemView);
            menuTeXT = itemView.findViewById(R.id.MekanIsmi);
            cardView = itemView.findViewById(R.id.MekanlarCardView);
            MekanAciklamasi = itemView.findViewById(R.id.MekanAciklamasi);

        }


    }








}

