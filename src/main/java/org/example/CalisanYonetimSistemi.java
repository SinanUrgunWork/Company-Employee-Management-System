package org.example;

import java.util.*;

public class CalisanYonetimSistemi {
    private List<Calisan> calisanlar;
    private  Map<String, List<Calisan>> managerEmployeeDictionary = new HashMap<>();

    public CalisanYonetimSistemi() {
        calisanlar = new ArrayList<>();
    }

    public void calisanEkle(Calisan calisan, Yonetici yonetici) {
        addEmployeeToManager(managerEmployeeDictionary, yonetici.ad, calisan);
        calisanlar.add(calisan);
        yonetici.personelEkle(calisan);
    }
    public void calisanCikart(int calisanId) {
        // İlgili çalışanı kimlik değerine göre çalışanlar listesinden çıkart
        Calisan calisanToRemove = null;
        for (Calisan calisan : calisanlar) {
            if (calisan.getId() == calisanId) {
                calisanToRemove = calisan;
                break;
            }
        }
        if (calisanToRemove != null) {
            calisanlar.remove(calisanToRemove);

            // İlgili çalışanı managerEmployeeDictionary'den de çıkart
            for (String manager : managerEmployeeDictionary.keySet()) {
                List<Calisan> employeesOfManager = managerEmployeeDictionary.get(manager);
                if (employeesOfManager.contains(calisanToRemove)) {
                    employeesOfManager.remove(calisanToRemove);
                    System.out.println("Çalışan ID " + calisanId + " başarıyla çıkartıldı.");
                    break;
                }
            }
        } else {
            System.out.println("Belirtilen kimlik değerine sahip çalışan bulunamadı.");
        }
    }
    public int idDogrulama(int id){
        Calisan calisanToRemove = null;
        for (Calisan calisan : calisanlar) {
            if (calisan.getId() == id) {
                calisanToRemove = calisan;
                break;
            }
        }
        if (calisanToRemove == null) {
            return id;
        } else {
            return 0;
        }
    }
    public void calisanlariListele() {
        for (Calisan calisan : calisanlar) {
            calisan.bilgileriGoster();
        }
    }
    public void yoneticiAltındakiCalısanlar(String yoneticiAdi){
        List<Calisan> employeesOfManager = getEmployeesForManager(managerEmployeeDictionary, yoneticiAdi);
        System.out.println("Yonetici: "+yoneticiAdi +"Calisanları: "+ employeesOfManager);

    }
    public Calisan calisanGetir(int id) {
        for (Calisan calisan : calisanlar) {
            if (calisan.getId() == id) {
                return calisan; // ID ile eşleşen çalışanı döndür
            }
        }
        return null; // ID ile eşleşen çalışan bulunamazsa null döndür
    }
    // CalisanYonetimSistemi sınıfında calisanIdMevcutMu metodunu ekleyin.
    public boolean calisanIdMevcutMu(int id) {
        for (Calisan calisan : calisanlar) {
            if (calisan.getId() == id) {
                return true; // ID mevcut ise true döndür
            }
        }
        return false; // ID mevcut değilse false döndür
    }
    public void calisaniAra(int id) {
        for (Calisan calisan : calisanlar) {
            if (calisan.getId() == id) {
                calisan.bilgileriGoster();
                return; // Çalışanı bulduktan sonra metodu sonlandır
            }
        }
        System.out.println("ID: " + id + " ile eşleşen çalışan bulunamadı.");
    }
    // Method to add an employee to a manager
    private static void addEmployeeToManager(Map<String, List<Calisan>> dictionary, String yonetici, Calisan calisan) {
        if (!dictionary.containsKey(yonetici)) {
            dictionary.put(yonetici, new ArrayList<>());
        }
        dictionary.get(yonetici).add(calisan);
    }

    // Method to get employees for a manager
    private static List<Calisan> getEmployeesForManager(Map<String, List<Calisan>> dictionary, String manager) {
        return dictionary.getOrDefault(manager, Collections.emptyList());
    }
}
