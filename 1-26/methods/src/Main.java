import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        duyuru();

        toplantiYap("Tunahan");
        soruSor("Tunahan");

        System.out.println( topla(6,4));
        System.out.println(toplaPlus(1,2,3,4,5));

        System.out.println(tarihAl());

        for(String davetli:davetEt("a","b","c","d")){
            System.out.println(davetli);
        }

    }

    public static void duyuru(){
        System.out.println("Toplantı duyurusu yapuldı");
    }

    public static   void toplantiYap(String isim){
        System.out.println(isim+" ile toplantı yapıldı");
    }

    public static String soruSor(String isim){
        return isim+" soru sordu";
    }

    public static int topla(int sayi1, int sayi2){
        return sayi1+sayi2;
    }
    public  static  int toplaPlus(int...sayilar){
        int toplam=0;
        for(int sayi:sayilar){
            toplam=toplam+sayi;
        }
        return toplam;
    }

    public static LocalDateTime tarihAl(){
        return LocalDateTime.now();
    }

    public static String[] davetEt(String... isimler){
        return isimler;
    }
}