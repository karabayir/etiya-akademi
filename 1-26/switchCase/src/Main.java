public class Main {
    public static void main(String[] args) {

        char licenseType ='ğ';
        String ageLimit= licenseType+" Ehliyet Yaş Sınırı: ";

        switch (licenseType){
            case 'A':
                System.out.println(ageLimit+20); break;
            case 'B':
                System.out.println(ageLimit+18); break;
            case 'C':
                System.out.println(ageLimit+21); break;
            case 'D':
                System.out.println(ageLimit+24); break;
            default:
                System.out.println("Geçersiz lisans tipi");
        }
    }
}