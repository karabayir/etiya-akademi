public class ProductValidator  { // ana class static olamaz

    static {
        System.out.println("static constructor çalıştı");
    }

    public static   boolean isValid(Product product){
       if (product.price > 0 && !product.name.isEmpty())
           return true;
       else {
           return false;
       }
    }
}
