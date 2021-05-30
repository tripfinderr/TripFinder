package com.crinsoft.sanalturrehberi;

import org.w3c.dom.Comment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {

    @GET("WebAPIForTrip/api/user/{UserId}")
    Call<List<KullaniciBilgileri>> getUserId(@Path("UserId") int UserId);

    @GET("WebAPIForTrip/api/user/ByUserNameKullaniciBilgileri")
    Call<List<KullaniciBilgileri>> getUserName(@Query("UserName") String UserName);

    @GET("WebAPIForTrip/api/user/ByuserSurnameKullaniciBilgileri")
    Call<List<KullaniciBilgileri>> getSurname(@Query("UserSurname") String UserSurName);


    @GET("WebAPIForTrip/api/user/ByUserMailAdressKullaniciBilgileri")
    Call<List<KullaniciBilgileri>> getMailAdress(@Query("UserMailAdress") String UserMailAdress);

    @GET("WebAPIForTrip/api/user/ByUserNickNameKullaniciBilgileri")
    Call<List<KullaniciBilgileri>> getUserNickName(@Query("UserNickName") String UserNickName);


    @GET("WebAPIForTrip/api/user/ByUserPasswordKullaniciBilgileri")
    Call<List<KullaniciBilgileri>> getUserPassword(@Query("UserPassword") String UserPassword);

    @GET("WebAPIForTrip/api/user/ByUserAgainPassword")
    Call<List<KullaniciBilgileri>> getUserAgainPassword(@Query("UserAgainPassword") String UserAgainPassword);




    @GET("WebAPIForTrip/api/user/ByTurIsmi")
    Call<List<KullaniciBilgileri>> getTurName(@Query("Turİsmi") String TurIsmi);

    @GET("WebAPIForTrip/api/user/TurBilgileri")
    Call<List<KullaniciBilgileri>> getTurlar();

    @GET("WebAPIForTrip/api/user/TurBilgileriDiscent")
    Call<List<KullaniciBilgileri>> getTurIsimleri();


    @GET("WebAPIForTrip/api/user/MekanBilgileri")
    Call<List<KullaniciBilgileri>> getMekanBilgileri(@Query("TurIsmi") String TurIsmi  );

    @GET("WebAPIForTrip/api/user/MekanAciklamasi")
    Call<List<KullaniciBilgileri>> getMekanAciklamasi(@Query("MekanIsimleri") String MekanAciklamalari  );

    @GET("WebAPIForTrip/api/user/KordinatGetir")
    Call<List<KullaniciBilgileri>> getKordinat(@Query("MekanIsimleri") String MekanIsmi  );






    @POST("WebAPIForTrip/api/user/KayitOl")
   Call<KullaniciBilgileri> createPost(@Body KullaniciBilgileri kullaniciBilgileri);

    @POST("WebAPIForTrip/api/user/FavEkle")
    Call<KullaniciBilgileri> FavEkle(@Body KullaniciBilgileri kullaniciBilgileri);

    @POST("WebAPIForTrip/api/user/YorumYap")
    Call<KullaniciBilgileri> YorumYap(@Body KullaniciBilgileri kullaniciBilgileri);



    //KullaniciBilgileriniGuncelleme

    @PUT("WebAPIForTrip/api/user/Guncelle")
    Call<KullaniciBilgileri> guncelle(@Query("UserId") int HesapUserId,@Body KullaniciBilgileri kullaniciBilgileri);

    @PUT("WebAPIForTrip/api/user/GuncelleSurname")
    Call<KullaniciBilgileri> guncelleSoyisim(@Query("UserId") int HesapUserId,@Body KullaniciBilgileri kullaniciBilgileri);

    @PUT("WebAPIForTrip/api/user/GuncelleMailAdresi")
    Call<KullaniciBilgileri> guncelleMailAdresi(@Query("UserId") int HesapUserId,@Body KullaniciBilgileri kullaniciBilgileri);

    @PUT("WebAPIForTrip/api/user/GuncelleKullaniciAdi")
    Call<KullaniciBilgileri> guncelleKullaniciAdi(@Query("UserId") int HesapUserId,@Body KullaniciBilgileri kullaniciBilgileri);

    @PUT("WebAPIForTrip/api/user/GuncelleSifre")
    Call<KullaniciBilgileri> guncelleSifre(@Query("UserId") int HesapUserId,@Body KullaniciBilgileri kullaniciBilgileri);








}
