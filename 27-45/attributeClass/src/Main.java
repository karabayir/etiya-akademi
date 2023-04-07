public class Main {
    public static void main(String[] args) {

        Product product= new Product();
        product.setId(1);
        product.setName("Fakir");
        product.setPrice(2023);
        product.setDescription("Kahve makinesi");
        product.setStockAmount(6);

        Product product2 = new Product(2,"Bosch","Kurutma Makinesi",20000,4);

        ProductManager productManager = new ProductManager();
        productManager.add(product);
        System.out.println(product.getCode());
        productManager.add(product2);
        System.out.println(product2.getCode());
    }
}