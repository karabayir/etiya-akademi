public class Main {
    public static void main(String[] args) {

        // 220-284 -> kendileri hariç pozitif tam bölenleri toplamı birbirne eşit ise arkadaş sayılardır

        int sayi1=220;
        int sayi2=284;
        int toplam1=0;
        int toplam2=0;

        if (sayi1<1 || sayi2<1){
            System.out.println("geçersiz sayı");
            return;
        }

        for (int i =1;i<sayi1;i++){
            if (sayi1 %i ==0)
                toplam1=toplam1+i;
        }
        for (int i =1;i<sayi2;i++){
            if (sayi2 %i ==0)
                toplam2=toplam2+i;
        }

        if (sayi1 == toplam2 && sayi2 == toplam1)
            System.out.println(sayi1+" ve "+sayi2+" arkadaş sayılardır");
        else
            System.out.println(sayi1+" ve "+sayi2+" arkadaş sayı değillerdir");
    }
}