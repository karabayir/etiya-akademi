public class Main {
    public static void main(String[] args) {
      BaseKrediManager[] baseKrediManager = {new AskerKrediManager(),new KonutKrediManager(),new TarimKrediManager()};

      for (BaseKrediManager  krediManager: baseKrediManager){
          System.out.println(krediManager.krediHesapla(1000));
      }

    }
}