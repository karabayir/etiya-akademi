public class Main {
    public static void main(String[] args) {
        int number =-23;
        boolean isPrime=true;

        if (number<1){
            System.out.println("geçersiz sayı");
            return;
        }


        for (int i=2;i<number;i++){
            if(number%2 == 0){
                isPrime=false;
            }
        }

        if (isPrime || number ==1)
            System.out.println(number+" asaldır");
        else
            System.out.println(number+" asal değildir");
    }
}