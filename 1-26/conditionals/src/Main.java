public class Main {
    public static void main(String[] args) {

        int playList= 26;
        int watched=10;

        if (watched< 0) {
            System.out.println("Trolleme :)");
        }
        else if (watched<playList){
            System.out.println("1.Gün workshop için "+playList+" seviyesine gelinmeli");
        }
        else if (watched==playList) {
            System.out.println("Tebrikler");
        } else {
            System.out.println("Sınıftan önde gidiyorsun :)");
        }



    }
}