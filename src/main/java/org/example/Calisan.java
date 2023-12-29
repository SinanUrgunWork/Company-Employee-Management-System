package org.example;

public class Calisan implements ICalisanBilgi  {
    protected String ad;
    protected String soyad;
    protected int id;

    public Calisan (String ad, String soyad, int id){
        this.ad=ad;
        this.soyad=soyad;
        this.id=id;
    }
    public String getAd() { return ad; }
    public void setAd(String ad) { this.ad = ad; }

    public String getSoyad() { return soyad; }
    public void setSoyad(String soyad) { this.soyad = soyad; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    @Override
    public void bilgileriGoster() {
        System.out.print("ID: " + id + ", Adı: " + ad + ", Soyadı: " + soyad + ", ");
    }
}
