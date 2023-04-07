public class Main {
    public static void main(String[] args) {

        FemaleCalculator femaleCalculator = new FemaleCalculator();
        MaleCalculator maleCalculator = new MaleCalculator();
        KidsGameCalculator kidsGameCalculator = new KidsGameCalculator();
        OlderCalculator olderCalculator = new OlderCalculator();

        femaleCalculator.hesapla();
        maleCalculator.hesapla();
        kidsGameCalculator.hesapla();
        olderCalculator.hesapla();

    }
}