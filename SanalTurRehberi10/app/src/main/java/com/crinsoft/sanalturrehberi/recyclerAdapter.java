package com.crinsoft.sanalturrehberi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class recyclerAdapter  extends RecyclerView.Adapter<recyclerAdapter.TheViewHolder> {
    private ArrayList<SeyehatBilgileri> SeyehatList;
    private OnNoteListener mOnNoteListener;







    public recyclerAdapter(ArrayList<SeyehatBilgileri> SeyehatList,OnNoteListener onNoteListener){
        this.SeyehatList =SeyehatList;
        this.mOnNoteListener=onNoteListener;

    }

    public class TheViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{

        private CardView seyehatPlaniCardView;
        private TextView SeyehatPlanIsmi;
        private TextView SeyehatPlanAciklamasi;
        OnNoteListener onNoteListener;


        public TheViewHolder(View view,OnNoteListener onNoteListener){
            super(view);
            seyehatPlaniCardView = view.findViewById(R.id.SeyehatPlaniCardView);
            SeyehatPlanIsmi = view.findViewById(R.id.SeyehatPlanIsmi);
            SeyehatPlanAciklamasi = view.findViewById(R.id.SeyehatPlanAciklamasi);
            this.onNoteListener=onNoteListener;

           itemView.setOnClickListener(this);






        }


        @Override
            public void onClick(View v) {
            onNoteListener.onNoteClick(getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public recyclerAdapter.TheViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.seyehat_planlari_list,parent,false);
        return  new TheViewHolder(itemView,mOnNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.TheViewHolder holder, int position) {
        String seyehatAdi= SeyehatList.get(position).getSeyahatİsmi();

        holder.SeyehatPlanIsmi.setText(seyehatAdi);
        String seyehatAciklamasi= SeyehatList.get(position).getSeyehatAciklamasi();
        holder.SeyehatPlanAciklamasi.setText(seyehatAciklamasi);





    }

    @Override
    public int getItemCount() {
        return SeyehatList.size();

    }

    public interface  OnNoteListener{
    void onNoteClick(int position);


    }


}
