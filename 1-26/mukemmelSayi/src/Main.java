public class Main {
    public static void main(String[] args) {

        // kendisinden başka tüm pozitif tan sayı bölenlerinin toplama kendisine eşit olan sayı
        // 6-> 1+2+3
        // 28->1+2+4+7+14

        int sayi=1;
        int toplam=0;

        if (sayi<2){
            System.out.println("Geçersiz sayı");
            return;
        }


        for (int i =1;i<sayi;i++ ){
            if (sayi % i ==0)
                toplam +=i;
        }

        if (toplam == sayi)
            System.out.println(sayi+" mükemmel sayıdır");
        else
            System.out.println(sayi+" mükemmel sayı değildir");
    }
}