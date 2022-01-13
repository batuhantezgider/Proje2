package proje1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class dnm {
    public static void main(String[] args) {

        HashMap<String ,ArrayList<Integer>> entry = new HashMap<>();
        ArrayList<Integer> notlar = new ArrayList<>();

        notlar.add(23);
        notlar.add(22);
        notlar.add(21);

        entry.put("Ali", new ArrayList<>(Arrays.asList(98, 45, 23, 34, 5)));
        entry.put("Mahmut",new ArrayList<>(Arrays.asList(34,100,12,89,53,99)));
        entry.put("Arda",notlar);


        listeleNotlar(entry);
        listeleOrtalamalar(entry);






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
    public static void listeleNotlar(HashMap<String, ArrayList<Integer>> liste){
        // Kodlarinizi buradan sonra yazin

        System.out.println("Ogrenci Notlari: ");

        for (Map.Entry<String, ArrayList<Integer>> entry : liste.entrySet()) {

            System.out.printf("%-10s", entry.getKey());


            for (Integer integer : entry.getValue()) {

                System.out.print(integer + "\t");

            }

            System.out.println();

        }


    }

    public static void listeleOrtalamalar(HashMap<String, ArrayList<Integer>> list){

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


}
