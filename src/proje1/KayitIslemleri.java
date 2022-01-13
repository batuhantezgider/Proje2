package proje1;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KayitIslemleri {



    /**
     * Key olarak ögrencinin adini ve
     * value olarak notlari kaydetmek icin bir Integer Arraylist
     * property"si olan bir HashMap tanimlayin
     * do loop icinde switch case kullanarak menüler icinde gezinin ve islemleri yapin
     */
    public static void main(String[] args) {

        Scanner scanner1 = new Scanner(System.in);

        HashMap<String, ArrayList<Integer>> list = new HashMap<>();
        ArrayList<Integer> notlar = new ArrayList<>();


        int islem;
        do {
            bekle(1000);
            islem = menu();
            System.out.println("---------------------------------");
            switch (islem){
                case 1:
                    // ogrenciKayit(); methodundan dönen Ögrenci ismini kullanicidan alip map"e ekleyin
                    // Kodlarinizi buradan sonra yazin

                    list.put(ogrenciKayit(),notlar);
                    break;


                case 2:
                    // list mapini println ile yazdirin
                    // Listelenen ögrenci isimlerinden kullanicinin isim isteyin.
                    // Kullanicinin girdigi isim icin ogrenciNotGirisi() methodunu kullanin ve
                    // ogrenci notlarini kaydedin
                    // hatali isim girilirse "Aranan Ogrenci Bulunamadi" uyarisi verin
                    // Kodlarinizi buradan sonra yazin

                    System.out.println(list);
                    System.out.print("Notunu girmek istediginiz ogrencinin ismini girin: ");
                    String isim2 = scanner1.nextLine();

                    isim2 = isimDuzenle(isim2);

                    if (list.containsKey(isim2))
                        ogrenciNotGirisi(isim2,list);

                    else
                        System.out.println("Aranan ogrenci bulunamadi");


                    break;

                case 3:
                    // notlari listele methodunu kullanarak tüm ögrencilerin notlarini listeletin
                    // Kodlarinizi buradan sonra yazin

                    if (list.isEmpty())
                        System.out.println("Ogrenci Listesi Bos !");

                    else
                        listeleNotlar(list);



                    break;

                case 4:
                    if (list.isEmpty())
                        System.out.println("Ogrenci Listesi Bos !");

                    else
                        listeleOrtalamalar(list);


                    break;

                case 0:
                    System.out.println("Cikis Yapiliyor...");

                    break;


                default:
                    System.out.println("Bu islem listede yok !");

                    break;

            }
        }while (islem != 0);
    }


    /**
     * Bu method parametre almayacak
     * Ekran görüntüsü asagidaki gibi olmali
     * Yapilacak islemin sira numarasini secin:
     * 1 : Yeni Ögrenci Kayit
     * 2 : Not Girisi
     * 3 : Ögrenci Notlari
     * 4 : Not Ortalamalari
     * 0 : Cikis
     * Seciminiz :
     */
    public static int menu(){
        // Kodlarinizi buradan sonra yazin

        Scanner scanner1 = new Scanner(System.in);


        int num;


            System.out.print("\nYapilacak islemin sira numarasini secin:\n" +
                    "1 : Yeni Ögrenci Kayit\n" +
                    "2 : Not Girisi\n" +
                    "3 : Ögrenci Notlari\n" +
                    "4 : Not Ortalamalari\n" +
                    "0 : Cikis\n" +
                    "Seciminiz : ");
            num = scanner1.nextInt();

        return num;
    }

    /**
     * Bu method parametre almayacak
     * scanner"dan girilen ogrenci ismini okuyacak.
     * isimDuzenle(String name); methodunu kullanarak ismi düzenleyecek
     * düzenlenmis ismi return edecek
     */
    public static String ogrenciKayit(){
        // Kodlarinizi buradan sonra yazin

        Scanner scanner1 = new Scanner(System.in);

        System.out.print("Ogrencinin ismini girin: ");
        String name = scanner1.nextLine();

        return isimDuzenle(name);
    }

    /**
     * Bu method bir String parametre alacak
     * aldigi Stringi düzenleyip return edecek.
     * Isim kac kelime ise her kelimenin ilk harfi büyük diger harfleri kücük ve
     * aralarinda bir bosluk olacak sekilde düzenleyecek.
     * str.trim().replaceAll("[ ]+"," ");  ifadesi
     * baştaki ve sondaki boşlukları siler, birden fayla bosluk da olsa yerine tek bosluk yazar.
     * Örnek:
     * name = "  jaVa    dunYA  " olarak methoda girse de
     * return "Java Dunya" seklinde olacak.
     */
    public static String isimDuzenle(String name){
        // Kodlarinizi buradan sonra yazin

        Scanner scanner1 = new Scanner(System.in);

        String sonDuzen = "";

        String duzenlenmisName = name.trim().replaceAll("[ ]+"," ");

        String[] arr = duzenlenmisName.split(" ");

        for (int i = 0; i < arr.length; i++) {
            sonDuzen += arr[i].substring(0,1).toUpperCase() + arr[i].substring(1).toLowerCase();
        }

        return sonDuzen.trim();
    }

    /**
     * Bu method bir String ve mainde tanimli HashMap'i parametre alacak
     * [0-100] arasi girilen tüm notlari bir ArrayList"e kaydedecek
     * [0-100] araligi disinda sayi girilirse bu sayiyi ArrayList"e kaydetmeyecek
     * ve döngüden cikacak. Sonra ismi gelen öğrenci hanesine map'a (list) ekleyecek (put methodu).
     * main'deki list HashMap'i bu methoda gönderirseniz, main'deki list'i güncellemiş olursunuz
     */
    public static void ogrenciNotGirisi(String ogrenciAdi, HashMap<String, ArrayList<Integer>> hashMap){
        // Kodlarinizi buradan sonra yazin

        Scanner scanner1 = new Scanner(System.in);
        ArrayList<Integer> notlar = new ArrayList<>();
        int not;

        do {
            not = scanner1.nextInt();

            if (not <= 100 && not >= 0)
                notlar.add(not);

        } while (not <= 100 && not >= 0);

        hashMap.put(ogrenciAdi, notlar);


    }

    /**
     * Bu method mainde tanimli HashMap'i (list) parametre alacak
     * kaydedilen tüm ögrencileri, notlari ile birlikte ekrana yazdiracak
     * Cikti asagidaki gibi olmali
     * Ogrenci Notlari
     * Ogrenci 1       50	60	 70	  60
     * Ogrenci 2       80	70	 60
     * İsim (map"in key"i) icin System.out.printf("%-20s", entry.getKey());
     * kullanırsanız, isim alanı için 20 karakterlik yer ayırır ve satır sonunda bekler
     * (System.out.printf()) kullanımın internetten araştırınız.
     * Loop ile ArrayList notlarini yazdirmak icin System.out.print(val + "\t");
     * kullanabilirsiniz. "\t" değer sonuna tab atmak için kullanabilirsiniz.
     */
    public static void listeleNotlar(HashMap<String , ArrayList<Integer>> list){
        // Kodlarinizi buradan sonra yazin

        System.out.println("Ogrenci Notlari: ");


        for (Map.Entry<String, ArrayList<Integer>> a : list.entrySet()) {

            System.out.printf("%-20s", a.getKey());


            for (Integer val : a.getValue()) {

                System.out.print(val + "\t");

            }

            System.out.println();

        }

    }

    /**
     * Bu method mainde tanimli HashMap'i (list) parametre alacak
     * kaydedilen tüm ögrencileri ve not ortalamalarini ekrana yazdiracak
     * Cikti asagidaki gibi olmali (System.out.printf("%.2f", val);  kullanarak yapin)
     * Ogrenci Not Ortalamalari
     * Ogrenci 1       55.43
     * Ogrenci 2       62.74
     * Output virgülden sonra 2 basamak olmali.
     */
    public static void listeleOrtalamalar(HashMap<String, ArrayList<Integer>> list){
        // Kodlarinizi buradan sonra yazin

        System.out.println("Ogrenci Ortalamalari: ");

        for (Map.Entry<String, ArrayList<Integer>> entry : list.entrySet()) {

            System.out.printf("%-10s", entry.getKey());


            ArrayList<Integer> nots = entry.getValue();

            double toplam = 0;

            for (int i = 0; i < nots.size(); i++) {

                toplam += nots.get(i);

            }
            System.out.printf("%.2f", toplam / nots.size());



            System.out.println();

        }


    }

    public static void bekle(long minis){

        try {
            Thread.sleep(minis);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        // 1 minis = 1 milisaniye.


    }

}
