public class Main {
    public static void main(String[] args) {

        ProductManager productManager = new ProductManager();
        Product product = new Product();
        product.id=1;
        product.name="Mouse";
        product.price=400;

        productManager.add(product);

        DatabaseHelper.Crud.add();       // inner class örnekleri Bu şekilde kullanım önerilmez. Single Responsibility
        DatabaseHelper.Connection.createCoonection(); //Benzer yapılar ayrıştırılmalıdır
    }
}