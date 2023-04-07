public class MySqlCustomerRepository implements  CustomerRepository{
    @Override
    public void add() {
        System.out.println("MySql ile eklendi");
    }
}
