package com.crinsoft.sanalturrehberi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NameUpdate extends AppCompatActivity {
    EditText editText;
    Button button;
    private static Retrofit retrofit=null;
    JsonPlaceHolderApi jsonPlaceHolderApi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_update);
        editText = findViewById(R.id.GuncelleUserName);
        button = findViewById(R.id.button2);




    }
    public void IsimGuncelle(View view){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        KullaniciBilgileri kullaniciBilgileri = new KullaniciBilgileri(editText.getText().toString(),null,null,null,null,null,null,null,null,null,null,null);

        Call<KullaniciBilgileri> call =jsonPlaceHolderApi.guncelle(1,kullaniciBilgileri);
        call.enqueue(new Callback<KullaniciBilgileri>() {
            @Override
            public void onResponse(Call<KullaniciBilgileri> call, Response<KullaniciBilgileri> response) {
                System.out.println("BAŞARILIIII");
            }

            @Override
            public void onFailure(Call<KullaniciBilgileri> call, Throwable t) {
                System.out.println("BAŞARISIZZZZ");

            }
        });




        Intent intent = new Intent(NameUpdate.this,HesapBilgileri.class);
        startActivity(intent);



    }



}