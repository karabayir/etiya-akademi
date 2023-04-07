public class Main {
    public static void main(String[] args) {
       CustomerManager customerManager = new CustomerManager(new OracleDatabaseManager());
       CustomerManager customerManager1 = new CustomerManager(new SqlServerDatabaseManager());
       customerManager.getCustomer();
       customerManager1.getCustomer();
    }
}