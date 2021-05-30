package com.crinsoft.sanalturrehberi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class HesapBilgileri extends AppCompatActivity {
    EditText HesapİsimText;
    EditText HesapSoyisimText;
    EditText HesapMailAdresiText;
    EditText HesapKullanıcıAdıText;
    EditText HesapSifreText;
    Dialog dialog;




    ImageView IsimImg;
    ImageView SoyisimImg;
    ImageView MailAdresiImg;
    ImageView KullaniciAdiImg;
    ImageView SifreImg;


    private static Retrofit retrofit=null;
    JsonPlaceHolderApi jsonPlaceHolderApi;
    String sessionId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hesap_bilgileri);
        HesapİsimText = findViewById(R.id.HesapİsimText);
        HesapSoyisimText = findViewById(R.id.HesapSoyisimText);
        HesapMailAdresiText = findViewById(R.id.HesapMailAdresiText);
        HesapKullanıcıAdıText = findViewById(R.id.HesapKullanıcıAdıText);
        HesapSifreText = findViewById(R.id.HesapSifreText);

         IsimImg = (ImageView) findViewById(R.id.IsimGuncelleImage);
         SoyisimImg = (ImageView) findViewById(R.id.SoyisimGuncelleImage);
        MailAdresiImg = (ImageView) findViewById(R.id.MailAdresiGuncelleImage);
        KullaniciAdiImg = (ImageView) findViewById(R.id.KullaniciAdiGuncelleImage);
        SifreImg = (ImageView) findViewById(R.id.SifreGuncelleImage);



        sessionId = getIntent().getStringExtra("KullaniciAdi");
        System.out.println(sessionId);





        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<KullaniciBilgileri>> call = jsonPlaceHolderApi.getUserNickName(sessionId);

        call.enqueue(new Callback<List<KullaniciBilgileri>>() {
            @Override
            public void onResponse(Call<List<KullaniciBilgileri>> call, Response<List<KullaniciBilgileri>> response) {

                List<KullaniciBilgileri> posts = response.body();
                for(KullaniciBilgileri post : posts){
                    String content ="";
                    content +="NickName: " +post.getUserNickName() + "UserPassword"+post.getUserPassword()+ "\n";

                    HesapİsimText.setText(post.getIsim());
                    HesapSoyisimText.setText(post.getUserSurname());
                    HesapMailAdresiText.setText(post.getUserMailAdress());
                    HesapKullanıcıAdıText.setText(post.getUserNickName());
                    HesapSifreText.setText(post.getUserPassword());












                }

            }

            @Override
            public void onFailure(Call<List<KullaniciBilgileri>> call, Throwable t) {
                call.enqueue(new Callback<List<KullaniciBilgileri>>() {
                    @Override
                    public void onResponse(Call<List<KullaniciBilgileri>> call, Response<List<KullaniciBilgileri>> response) {

                    }

                    @Override
                    public void onFailure(Call<List<KullaniciBilgileri>> call, Throwable t) {

                    }
                });


            }
        });









    }
    public void HesapBilgileriGuncelleUserName(View view){
        HesapİsimText = findViewById(R.id.HesapİsimText);
        HesapSoyisimText = findViewById(R.id.HesapSoyisimText);
        HesapMailAdresiText = findViewById(R.id.HesapMailAdresiText);
        HesapKullanıcıAdıText = findViewById(R.id.HesapKullanıcıAdıText);
        HesapSifreText = findViewById(R.id.HesapSifreText);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);






    }
    public void IsimGuncelleDialog(View view){

    Intent intent = new Intent(this,NameUpdate.class);
    startActivity(intent);




    }
    public void SoyisimGuncelle(View view){
        Intent intent = new Intent(this,SurnameUpdate.class);
        startActivity(intent);

    }








}