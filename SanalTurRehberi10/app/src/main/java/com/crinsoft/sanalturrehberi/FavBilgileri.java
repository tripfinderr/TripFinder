package com.crinsoft.sanalturrehberi;

public class FavBilgileri {

    private String UserNickName;
    private String MekanIsimleri;
    public String Favori;

    public void setUserNickName(String userNickName) {
        UserNickName = userNickName;
    }

    public void setMekanIsimleri(String mekanIsimleri) {
        MekanIsimleri = mekanIsimleri;
    }

    public void setFavori(String favori) {
        Favori = favori;
    }



    public String getUserNickName() {
        return UserNickName;
    }

    public String getMekanIsimleri() {
        return MekanIsimleri;
    }

    public String getFavori() {
        return Favori;
    }



    public FavBilgileri(String userNickName, String mekanIsimleri, String favori) {
        UserNickName = userNickName;
        MekanIsimleri = mekanIsimleri;
        Favori = favori;
    }
}
