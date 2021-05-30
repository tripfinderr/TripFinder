package com.crinsoft.sanalturrehberi;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class KayitOlActivity extends AppCompatActivity {
    TextView textViewdeneme;
    TextView textViewkullaniciAdi;
    TextView textViewsifre;
    //KayıtOl
    EditText KIsim;
    EditText KSoyisim;
    EditText KMailAdresi;
    EditText KKullaniciAdi;
    EditText KSifre;
    EditText KTekrarSifre;

    private static Retrofit retrofit=null;
    JsonPlaceHolderApi jsonPlaceHolderApi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit_ol);








    }
    public void KayitOlToLoginPage(View view){
        KIsim = findViewById(R.id.IsimTextView);
        KSoyisim = findViewById(R.id.SoyisimTextView);
        KKullaniciAdi = findViewById(R.id.KullaniciAdiSorunlu);
        KMailAdresi = findViewById(R.id.MailAdresiTextView);
        KSifre = findViewById(R.id.SifreTextView);
        KTekrarSifre = findViewById(R.id.SifreTekrarTextView);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);


        KullaniciBilgileri kullaniciBilgileri =
                new KullaniciBilgileri
                (KIsim.getText().toString(),
                KSoyisim.getText().toString(),
                KMailAdresi.getText().toString(),
               KKullaniciAdi.getText().toString(),
               KSifre.getText().toString(),
                KTekrarSifre.getText().toString(),
                        null,
                        null,
                        null,null,null,null);


        if(KSifre.getText().toString().equals(KTekrarSifre)){





        Call<KullaniciBilgileri> call = jsonPlaceHolderApi.createPost(kullaniciBilgileri);

        call.enqueue(new Callback<KullaniciBilgileri>() {
            @Override
            public void onResponse(Call<KullaniciBilgileri> call, Response<KullaniciBilgileri> response) {



               Toast toast = Toast.makeText(getApplicationContext(), "Başarılı bir şekilde kullanıcı oluşturuldu!", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.show();




            }

            @Override
            public void onFailure(Call<KullaniciBilgileri> call, Throwable t) {
             //   Toast toast = Toast.makeText(getApplicationContext(), "Kullanıcı Oluşturulamadı!", Toast.LENGTH_LONG);
              //  toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
               // toast.show();
            }
        });

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        }
        else {
            Toast toast = Toast.makeText(getApplicationContext(), "Kullanıcı Oluşturulamadı!", Toast.LENGTH_LONG);
              toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
              toast.show();
        }


        }

    }




