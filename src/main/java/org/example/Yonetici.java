package org.example;

import java.util.*;

public class Yonetici extends Calisan{
    private String departman;
    private List<Calisan> altindaCalisanlar= new ArrayList<>();
    public Yonetici(String ad, String soyad, int id) {
        super(ad, soyad, id);
    }
    public void personelEkle(Calisan calisan) {
        altindaCalisanlar.add(calisan);
    }
    public void personelCikar(Calisan calisan) {
        altindaCalisanlar.remove(calisan);
    }
    public void altindaCalisanlariListele() {
        for (Calisan calisan : altindaCalisanlar) {
            calisan.bilgileriGoster();
        }
    }
    public String getDepartman() {
        return departman;
    }

}
