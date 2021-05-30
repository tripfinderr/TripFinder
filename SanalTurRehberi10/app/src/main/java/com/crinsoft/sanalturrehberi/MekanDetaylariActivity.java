package com.crinsoft.sanalturrehberi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.sql.SQLOutput;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MekanDetaylariActivity extends AppCompatActivity {
    String mekanBilgisi;
    TextView mekanDetayIsmi;
    TextView mekanDetayAciklamasi;
    private static Retrofit retrofit=null;
    JsonPlaceHolderApi jsonPlaceHolderApi;
    String Lat=" ";
    String Lng=" ";
    String LatLng="";
    String UserNickName="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mekan_detaylari);
        getIncomingIntent();
        mekanDetayAciklamasi=findViewById(R.id.mekanDetayAciklamasi);
        mekanDetayIsmi = findViewById(R.id.mekanDetayIsmi);
        mekanDetayIsmi.setText(mekanBilgisi);
        mekanAciklamasiGetir();

        getLatLong();










    }


    private void getIncomingIntent(){



             mekanBilgisi=getIntent().getStringExtra("mekanBilgisi");
            //Toast toast = Toast.makeText(this,mekanBilgisi, Toast.LENGTH_SHORT);
            //toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
            //toast.show();
            UserNickName=getIntent().getStringExtra("UserNickName");
        Toast toast = Toast.makeText(this,"UserNickName"+UserNickName, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();








    }
    public void mekanAciklamasiGetir(){

        Retrofit retrofit = new Retrofit.Builder()
               .baseUrl("http://10.0.2.2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<KullaniciBilgileri>> call = jsonPlaceHolderApi.getMekanAciklamasi(mekanDetayIsmi.getText().toString());
        call.enqueue(new Callback<List<KullaniciBilgileri>>() {
            @Override
            public void onResponse(Call<List<KullaniciBilgileri>> call, Response<List<KullaniciBilgileri>> response) {
                List<KullaniciBilgileri> posts = response.body();
                for(KullaniciBilgileri post : posts){

                    mekanDetayAciklamasi.setText(post.getMekanAciklamalari());



                }
            }

            @Override
            public void onFailure(Call<List<KullaniciBilgileri>> call, Throwable t) {

            }
        });


    }

    public void showMarker(View view){
        getLatLong();
        Intent intent = new Intent(this,GoogleMapActivity.class);
        intent.putExtra("deneme",getLatLong());
        intent.putExtra("MekanIsmi",mekanBilgisi);
        startActivity(intent);

    }




    public String getLatLong(){
      //  Retrofit retrofit = new Retrofit.Builder()
        //        .baseUrl("http://10.0.2.2/")
          //      .addConverterFactory(GsonConverterFactory.create())
            //    .build();
       // jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<List<KullaniciBilgileri>> call = jsonPlaceHolderApi.getKordinat(mekanBilgisi);
        call.enqueue(new Callback<List<KullaniciBilgileri>>() {
            @Override
            public void onResponse(Call<List<KullaniciBilgileri>> call, Response<List<KullaniciBilgileri>> response) {
                List<KullaniciBilgileri> posts = response.body();
                for(KullaniciBilgileri post : posts){
                     LatLng =post.getKordinatlar();






                }
            }

            @Override
            public void onFailure(Call<List<KullaniciBilgileri>> call, Throwable t) {

            }
        });

       // Intent intent = new Intent(this,GoogleMapActivity.class);
        // intent.putExtra("Lat",Lat);
        //intent.putExtra("Lng",Lng);
       // startActivity(intent);
        return LatLng;
    }

    public void YorumYap(View view){

        Intent intent = new Intent(MekanDetaylariActivity.this,YorumYapActivity.class);
        intent.putExtra("MekanIsmi",mekanDetayIsmi.getText().toString());
        intent.putExtra("UserNickName",UserNickName);
        startActivity(intent);







    }





    public void favEkle(View view){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        KullaniciBilgileri kullaniciBilgileri =
                new KullaniciBilgileri
                        (null,
                                null,
                                null,
                                UserNickName,
                                null,
                                null,
                                null,
                                mekanDetayIsmi.getText().toString(),
                                null,null,"YES",null);



        Call<KullaniciBilgileri> call = jsonPlaceHolderApi.FavEkle(kullaniciBilgileri);
        call.enqueue(new Callback<KullaniciBilgileri>() {
            @Override
            public void onResponse(Call<KullaniciBilgileri> call, Response<KullaniciBilgileri> response) {
                System.out.println("Favorilere Eklendi!");
                Toast toast = Toast.makeText(MekanDetaylariActivity.this,"Favorilere Eklendi!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.show();

            }

            @Override
            public void onFailure(Call<KullaniciBilgileri> call, Throwable t) {
                System.out.println("Favorilere EKLENEMEDİ");
                Toast toast = Toast.makeText(MekanDetaylariActivity.this,"Favorilere Eklendi!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.show();
            }
        });








    }




}