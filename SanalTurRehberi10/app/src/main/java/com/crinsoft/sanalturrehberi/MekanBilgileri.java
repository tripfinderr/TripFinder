package com.crinsoft.sanalturrehberi;

public class MekanBilgileri {

    private String mekanIsmi;
    private String mekanKordinat;
    public String mekanAciklamasi;

    public String getMekanAciklamasi() {
        return mekanAciklamasi;
    }



    public void setMekanIsmi(String mekanIsmi) {
        this.mekanIsmi = mekanIsmi;
    }

    public void setMekanKordinat(String mekanKordinat) {
        this.mekanKordinat = mekanKordinat;
    }



    public String getMekanIsmi() {
        return mekanIsmi;
    }

    public String getMekanKordinat() {
        return mekanKordinat;
    }

    public MekanBilgileri(String mekanIsmi, String mekanKordinat,String mekanAciklamasi) {
        this.mekanIsmi = mekanIsmi;
        this.mekanKordinat = mekanKordinat;
        this.mekanAciklamasi=mekanAciklamasi;
    }
}
