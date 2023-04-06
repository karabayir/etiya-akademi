public class Main {
    public static void main(String[] args) {

        // for
        System.out.println("for");
        for (int i=1;i<10;i++){
            System.out.println(i);
        }

        //while
        System.out.println("while");
        int i=1;
        while(i<10){
            System.out.println(i);
            i++;
        }
        System.out.println("do while"); // döngü çalışmasa bile db'ye log atsın ya da her ne ise en az 1 defa çalışsın.
        int t=1;
        do {
            System.out.println(t);
            t++;
        }while (t<10);

    }
}