package com.crinsoft.sanalturrehberi;

import com.google.gson.annotations.SerializedName;

public class KullaniciBilgileri {
    //Kullanici Bilgileri
    @SerializedName("UserId")
    private int KullaniciID;
    @SerializedName("UserName")
    private String Isim;
    @SerializedName("UserSurname")
    private String UserSurname;
    @SerializedName("UserMailAdress")
    private String userMailAdress;
    @SerializedName("UserNickName")
    private String UserNickName;
    @SerializedName("UserPassword")
    private String UserPassword;
    @SerializedName("UserAgainPassword")
    private String UserAgainPassword;

    //TurBilgileri
    @SerializedName("Turİsmi")
    private String TurIsmi;

    @SerializedName("MekanIsimleri")
    private String MekanIsimleri;

    @SerializedName("Kordinatlar")
    private String Kordinatlar;


    @SerializedName("MekanAciklamalari")
    private String MekanAciklamalari;

    @SerializedName("Favori")
    private String Favori;

    @SerializedName("MekanYorumu")
    private String MekanYorumu;




    public String getMekanYorumu() {
        return MekanYorumu;
    }
    public String getFavori() {
        return Favori;
    }
    public String getMekanAciklamalari() {
        return MekanAciklamalari;
    }

    public String getTurIsmi() {
        return TurIsmi;
    }

    public String getMekanIsimleri() {
        return MekanIsimleri;
    }

    public String getKordinatlar() {
        return Kordinatlar;
    }

    public int getKullaniciID() {
        return KullaniciID;
    }

    public String getIsim() {
        return Isim;
    }

    public String getUserSurname() {
        return UserSurname;
    }

    public String getUserMailAdress() {
        return userMailAdress;
    }

    public String getUserNickName() {
        return UserNickName;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public String getUserAgainPassword() {
        return UserAgainPassword;
    }

    public KullaniciBilgileri(String isim, String userSurname, String userMailAdress, String userNickName, String userPassword, String userAgainPassword,String TurIsmi,String MekanIsimleri,String Kordinatlar,String MekanAciklamalari,String Favori,String MekanYorumu ) {
        this.Isim = isim;
        this.UserSurname = userSurname;
        this.userMailAdress = userMailAdress;
        this.UserNickName = userNickName;
        this.UserPassword = userPassword;
        this.UserAgainPassword = userAgainPassword;
        this.TurIsmi = TurIsmi;
        this.MekanIsimleri = MekanIsimleri;
        this.Kordinatlar = Kordinatlar;
        this.MekanAciklamalari=MekanAciklamalari;
        this.Favori=Favori;
        this.MekanYorumu=MekanYorumu;
    }
}
