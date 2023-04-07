public class PostgreSqlCustomerRepository implements  CustomerRepository{
    @Override
    public void add() {
        System.out.println("PostgreSql ile eklendi");
    }
}
