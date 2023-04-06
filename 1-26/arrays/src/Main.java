public class Main {

    public static void main(String[] args) {


        double prisonBreak=7.8;
        double lordOfTheRings=6.3;
        double hobbit=7.1;
        double narcos=8.6;

        double puanlar[] = {prisonBreak,lordOfTheRings,narcos,hobbit};
        double enIyı=hobbit;


        for(int i=0; i<puanlar.length; i++){
            if (enIyı<puanlar[i])
                enIyı=puanlar[i];
        }
        System.out.println(enIyı);
    }

}