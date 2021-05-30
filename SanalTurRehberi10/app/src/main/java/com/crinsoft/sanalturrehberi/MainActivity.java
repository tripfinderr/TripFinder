package com.crinsoft.sanalturrehberi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    TextView textViewdeneme;
    TextView textViewkullaniciAdi;
    TextView textViewsifre;
    //KayıtOl
    TextView KIsim;
    TextView KSoyisim;
    TextView KMailAdresi;
    TextView KKullaniciAdi;
    TextView KSifre;
    TextView KTekrarSifre;

    private static Retrofit retrofit=null;
    JsonPlaceHolderApi jsonPlaceHolderApi;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





    }
    public void getPosts(){
        Call<List<KullaniciBilgileri>> call = jsonPlaceHolderApi.getUserId(6);

        call.enqueue(new Callback<List<KullaniciBilgileri>>() {
            @Override
            public void onResponse(Call<List<KullaniciBilgileri>> call, Response<List<KullaniciBilgileri>> response) {
                if(!response.isSuccessful()){
                    textViewdeneme.setText("code"+ response.code());
                    return;

                }
                List<KullaniciBilgileri> posts = response.body();
                for(KullaniciBilgileri post : posts){
                    String content ="";
                    content +="Name: " +post.getIsim() + "\n";


                    textViewdeneme.append(content);

                }

            }

            @Override
            public void onFailure(Call<List<KullaniciBilgileri>> call, Throwable t) {
                textViewdeneme.setText(t.getMessage());
            }
        });

    }

    private void createpost(){
    KullaniciBilgileri kullaniciBilgileri = new KullaniciBilgileri("apisim1","apisoyisim1","apimail1","apinickname1","apipass1","apiagainpass1",null,null,null,null,null,null);
    Call<KullaniciBilgileri> call = jsonPlaceHolderApi.createPost(kullaniciBilgileri);
    call.enqueue(new Callback<KullaniciBilgileri>() {
        @Override
        public void onResponse(Call<KullaniciBilgileri> call, Response<KullaniciBilgileri> response) {

            System.out.println("Sistem başarılı");
            return;

        }

        @Override
        public void onFailure(Call<KullaniciBilgileri> call, Throwable t) {
            System.out.println(t);
        }
    });

    }



    public void KayitOl(View view){
        Intent intent = new Intent(this,KayitOlActivity.class);
        startActivity(intent);




    }
    public void feedPage(View view){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);



        textViewdeneme = findViewById(R.id.textView14);
        textViewkullaniciAdi = findViewById(R.id.kullaniciAdiTextView);
        textViewsifre = findViewById(R.id.sifreTextView);
         String kullaniciAdi;




        Call<List<KullaniciBilgileri>> call = jsonPlaceHolderApi.getUserNickName(textViewkullaniciAdi.getText().toString());

        call.enqueue(new Callback<List<KullaniciBilgileri>>() {
            @Override
            public void onResponse(Call<List<KullaniciBilgileri>> call, Response<List<KullaniciBilgileri>> response) {


                List<KullaniciBilgileri> posts = response.body();
                for(KullaniciBilgileri post : posts){
                    String content ="";
                    content +="NickName: " +post.getUserNickName() + "UserPassword"+post.getUserPassword()+ "\n";


                    if (post.getUserNickName().length()>0 && post.getUserPassword().length()>0  ){


                        if((post.getUserNickName().equals(textViewkullaniciAdi.getText().toString())) && (post.getUserPassword().equals(textViewsifre.getText().toString()))){

                            Intent intent = new Intent(MainActivity.this, FeedSayfasi.class);
                           intent.putExtra("KullaniciAdi",textViewkullaniciAdi.getText().toString() );
                            startActivity(intent);





                            Toast toast = Toast.makeText(getApplicationContext(), "Başarılı bir şekilde login olundu!", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                            toast.show();
                        }
                        else {
                            Toast toast = Toast.makeText(getApplicationContext(), "Login Olunamadı!", Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                            toast.show();

                        }

                    }





                }

            }

            @Override
            public void onFailure(Call<List<KullaniciBilgileri>> call, Throwable t) {
                textViewdeneme.setText(t.getMessage());
            }
        });





















    }

}