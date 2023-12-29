package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ad;
        String soyad;
        int id;
        Calisan geciciCalisan;
        Yonetici geciciYonetici;
        Yonetici anaYonetici=new Yonetici("sinan","urgun",1);
        CalisanYonetimSistemi yonetimSistemi = new CalisanYonetimSistemi();
        while (true) {
            System.out.println("\nÇalışan Yönetim Sistemi Menüsü");
            System.out.println("Burda yapılan işlemler Ana Yonetici uzerinden yapilmaktadir. Degistirmek icin 9. secenegi seciniz");
            System.out.println("1. Çalışan Ekle");
            System.out.println("2. Çalışan Ara");
            System.out.println("3. Çalışan Çıkar");
            System.out.println("4. Yonetici ekle");
            System.out.println("5. Yonetici islemleri(personel ekle)");
            System.out.println("6. Yonetici islemleri(personelleri listele)");
            System.out.println("7. Yonetici islemleri(departmanı öğren)");
            System.out.println("8. Çalışanları Listele");
            System.out.println("9. Yonetici degistir ");
            System.out.println("10. Çıkış");
            System.out.print("Seçiminiz: ");
            int secim = scanner.nextInt();
            scanner.nextLine(); // Input buffer'ını temizlemek için

            switch (secim) {
                case 1:
                    System.out.print("Lutfen calisanin adini yazınız: ");
                     ad = scanner.nextLine();
                    System.out.println();
                    System.out.print("Lutfen calisanin soyadini yazınız: ");
                     soyad = scanner.nextLine();
                    System.out.println();
                    System.out.print("Lutfen calisanin id'sini giriniz: ");
                     id = Integer.parseInt(scanner.nextLine());
                     System.out.println();
                     if(yonetimSistemi.idDogrulama(id)==id){
                         System.out.println("Bu idye sahip baska bir calisan bulunmaktadir. ");
                     }else{
                         Calisan yeniCalisan=new Calisan(ad,soyad,id);
                         yonetimSistemi.calisanEkle(yeniCalisan,anaYonetici);
                     }
                    break;
                case 2:
                    System.out.print("Lutfen aramak istediginiz calisanin id'sini giriniz: ");
                    id = Integer.parseInt(scanner.nextLine());
                    System.out.println();
                    if(yonetimSistemi.idDogrulama(id)==id){
                        geciciCalisan = yonetimSistemi.calisanGetir(id);
                        geciciCalisan.bilgileriGoster();
                    }else{
                        System.out.println("Bu id ye sahip bir calisan Bulunamadı.");
                    }
                    break;
                case 3:
                    System.out.print("Lutfen çıkarmak istediginiz calisanin id'sini giriniz: ");
                    id = Integer.parseInt(scanner.nextLine());
                    System.out.println();
                    if(yonetimSistemi.idDogrulama(id)==id){
                        yonetimSistemi.calisanCikart(id);
                    }else{
                        System.out.println("Girmis oldugunuz id kimseye ait degildir. ");
                    }
                    break;
                case 4:
                    System.out.print("Lutfen Yoneticinin adini yazınız: ");
                    ad = scanner.nextLine();
                    System.out.println();
                    System.out.print("Lutfen Yoneticinin soyadini yazınız: ");
                    soyad = scanner.nextLine();
                    System.out.println();
                    System.out.print("Lutfen Yoneticinin id'sini giriniz: ");
                    id = Integer.parseInt(scanner.nextLine());
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    System.out.println("Programdan çıkılıyor...");
                    System.exit(0); // Programdan çıkış
                    break;
                default:
                    System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
            }
        }
    }
}