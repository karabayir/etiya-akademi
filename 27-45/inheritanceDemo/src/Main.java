public class Main {
    public static void main(String[] args) {
        TarimKrediManager tarimKrediManager = new TarimKrediManager();
        AskerKrediManager askerKrediManager = new AskerKrediManager();

        // Aynı zamanda poliformizm bir yapıdır.
        KrediUI krediUI = new KrediUI();
        krediUI.krediHesapla(askerKrediManager);
        krediUI.krediHesapla(tarimKrediManager);
        krediUI.krediHesapla(new KonutKrediManager());

    }
}