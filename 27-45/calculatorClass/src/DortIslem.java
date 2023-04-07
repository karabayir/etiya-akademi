public class DortIslem {

    public int topla(int sayi1, int sayi2){
        return  sayi1+sayi2;
    }

    public int cikar(int sayi1, int sayi2){
        return Math.abs(sayi1-sayi2);
    }

    public int carp(int sayi1, int sayi2){
        return sayi1*sayi2;
    }

    public int bol(int sayi1, int sayi2){
        if (sayi2==0){
            System.out.println("payda 0 olmamalıdır");
            return 0;
        }
        return sayi1/sayi2;
    }
}
