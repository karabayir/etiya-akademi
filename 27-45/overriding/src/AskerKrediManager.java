public class AskerKrediManager extends  BaseKrediManager {
    @Override
    public double krediHesapla(double tutar) {
        return tutar*1.21;
    }
}
