public class CustomerManager {

    CustomerRepository customerRepository;

    public CustomerManager(CustomerRepository repository){
        this.customerRepository = repository;
    }

    public void add(){
        System.out.println("Customer Eklendi");
        customerRepository.add();
    }
}
