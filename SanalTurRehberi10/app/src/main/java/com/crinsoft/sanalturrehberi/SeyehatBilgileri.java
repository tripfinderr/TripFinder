package com.crinsoft.sanalturrehberi;

import android.content.Intent;

public class SeyehatBilgileri {

    private String Seyahatİsmi;
    private String SeyehatAciklamasi;

    public void setSeyahatİsmi(String seyahatİsmi) {
        Seyahatİsmi = seyahatİsmi;
    }

    public void setSeyehatAciklamasi(String seyehatAciklamasi) {
        SeyehatAciklamasi = seyehatAciklamasi;
    }

    public String getSeyahatİsmi() {
        return Seyahatİsmi;
    }

    public String getSeyehatAciklamasi() {
        return SeyehatAciklamasi;
    }

    public SeyehatBilgileri(String seyahatİsmi, String seyehatAciklamasi) {
        this.Seyahatİsmi = seyahatİsmi;
        this.SeyehatAciklamasi = seyehatAciklamasi;




    }

}
