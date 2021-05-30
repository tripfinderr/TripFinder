package com.crinsoft.sanalturrehberi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class YorumYapActivity extends AppCompatActivity {
    private static Retrofit retrofit=null;
    JsonPlaceHolderApi jsonPlaceHolderApi;
    String UserNickName;
    String TurIsmi;
    String MekanIsmi;
    EditText YorumMultiLine;
    TextView YorumIsim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yorum_yap);
        Intent intent = getIntent();
        YorumMultiLine=findViewById(R.id.YorumMultiLine);
        YorumIsim = findViewById(R.id.YorumIsim);

       UserNickName = intent.getStringExtra("UserNickName");
       MekanIsmi=intent.getStringExtra("MekanIsmi");

       YorumIsim.setText(MekanIsmi);






    }



    public void YorumYap(View view){
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
                                MekanIsmi,
                                null,null,null,YorumMultiLine.getText().toString());








            Call<KullaniciBilgileri> call = jsonPlaceHolderApi.YorumYap(kullaniciBilgileri);

            call.enqueue(new Callback<KullaniciBilgileri>() {
                @Override
                public void onResponse(Call<KullaniciBilgileri> call, Response<KullaniciBilgileri> response) {



                    Toast toast = Toast.makeText(getApplicationContext(), "Başarılı bir şekilde yorum oluşturuldu, Teşekkürler!", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();




                }

                @Override
                public void onFailure(Call<KullaniciBilgileri> call, Throwable t) {
                      Toast toast = Toast.makeText(getApplicationContext(), "Yorum Oluşturulamadı! Tekrar Deneyiniz!", Toast.LENGTH_LONG);
                     toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                     toast.show();
                }
            });

        Intent intent = new Intent(YorumYapActivity.this,MekanDetaylariActivity.class);
        startActivity(intent);





        }
}