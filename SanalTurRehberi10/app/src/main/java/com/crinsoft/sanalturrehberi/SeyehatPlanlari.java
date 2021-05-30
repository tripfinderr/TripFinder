package com.crinsoft.sanalturrehberi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SeyehatPlanlari extends AppCompatActivity implements recyclerAdapter.OnNoteListener {
    private ArrayList<SeyehatBilgileri> seyehatBilgileri;
    RecyclerView recyclerView;
    recyclerAdapter adapter;
    RecyclerView.LayoutManager mLayoutManager;
    String UserNickName;


    private static Retrofit retrofit=null;
    JsonPlaceHolderApi jsonPlaceHolderApi;
    TextView SeyehatPlanIsmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getTurİsimleriAPI();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seyehat_planlari);
        recyclerView = findViewById(R.id.recyclerView2);
        recyclerView.setHasFixedSize(true);
        seyehatBilgileri = new ArrayList<>();



        setAdapter();

        Intent intent = getIntent();
        UserNickName=  intent.getStringExtra("UserNickName");








    }






    private void setAdapter() {
         adapter = new recyclerAdapter(seyehatBilgileri,this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);



    }



    public  void getTurİsimleriAPI(){


        seyehatBilgileri = new ArrayList<>();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<KullaniciBilgileri>> call = jsonPlaceHolderApi.getTurIsimleri();

        call.enqueue(new Callback<List<KullaniciBilgileri>>() {
            @Override
            public void onResponse(Call<List<KullaniciBilgileri>> call, Response<List<KullaniciBilgileri>> response) {
                List<KullaniciBilgileri> posts = response.body();
                for(KullaniciBilgileri post : posts){

                    System.out.println("Tur İsmi:"+post.getTurIsmi());
                    seyehatBilgileri.add(new SeyehatBilgileri(post.getTurIsmi(),"yanlıkkk"));


                }

            }
            @Override
            public void onFailure(Call<List<KullaniciBilgileri>> call, Throwable t) {
                System.out.println("ÇALIŞMIYOR");

            }
        });




    }


    @Override
    public void onNoteClick(int position) {
        int a;
        //seyehatBilgileri.get(position);
        a = position;
        Toast toast = Toast.makeText(getApplicationContext(), "Clicked"+a, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
        Intent intent = new Intent(this,TurMekanlari.class);
        intent.putExtra("deneme",a);
        intent.putExtra("UserNickName",UserNickName);
        startActivity(intent);
    }
}