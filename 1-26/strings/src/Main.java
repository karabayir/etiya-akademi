public class Main {
    public static void main(String[] args) {

        String mesaj = "Etiya Akademi";
        System.out.println(mesaj);
        System.out.println("mesaj eleman sayısı: "+mesaj.length());
        System.out.println("5. eleman:"+mesaj.charAt(4));
        System.out.println(mesaj.concat(" Back End"));
        System.out.println(mesaj.indexOf('t')); // t harfi kaçıncı indiste
        System.out.println(mesaj.trim());

        for (String kelime : mesaj.split(" ")){
            System.out.println(kelime);
        }
    }
}