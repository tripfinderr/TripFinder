package com.crinsoft.sanalturrehberi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TurMekanlari extends AppCompatActivity {
    String abcdef;
    String abc;
    TextView textView;
    private static Retrofit retrofit=null;
    JsonPlaceHolderApi jsonPlaceHolderApi;
    int deneme;
    String TurIsmi;
    RecyclerView recyclerView;
    ExampleAdapter adapter;
    RecyclerView.LayoutManager mLayoutManager;
   private String UserNickName;

    public String getUserNickName() {
        return UserNickName;
    }



    private ArrayList<MekanBilgileri> mekanBilgileris;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        deneme =intent.getIntExtra("deneme",0);
        UserNickName=intent.getStringExtra("UserNickName");
        TurIsmi="Klasik"+(deneme+1);

        getTurMekanlari();
        mekanBilgileris = new ArrayList<>();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tur_mekanlari);


        recyclerView = findViewById(R.id.recyclerView10);
        recyclerView.setHasFixedSize(true);

        setAdapter();



    }

    public void getTurMekanlari(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<KullaniciBilgileri>> call = jsonPlaceHolderApi.getMekanBilgileri(TurIsmi);





        call.enqueue(new Callback<List<KullaniciBilgileri>>() {
            @Override
            public void onResponse(Call<List<KullaniciBilgileri>> call, Response<List<KullaniciBilgileri>> response) {
                List<KullaniciBilgileri> posts = response.body();
                for(KullaniciBilgileri post : posts){

                    System.out.println("Tur İsmi:"+post.getMekanIsimleri());
                    mekanBilgileris.add(new MekanBilgileri(post.getMekanIsimleri(),post.getKordinatlar(),post.getMekanAciklamalari()));


                }

            }

            @Override
            public void onFailure(Call<List<KullaniciBilgileri>> call, Throwable t) {


            }
        });

    }
    private void setAdapter() {
        adapter = new ExampleAdapter(mekanBilgileris,this,UserNickName);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);



    }
}