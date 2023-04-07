public class Main {
    public static void main(String[] args) {

        BaseLogger[] loggers = new BaseLogger[]{new FileLogger(),new DatebaseLogger(),new EmailLogger(),new ConsoleLogger()};

        CustomerManager customerManager = new CustomerManager(new ConsoleLogger());
        customerManager.add();
    }
}