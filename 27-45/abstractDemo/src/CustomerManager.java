public class CustomerManager {

    BaseDatabaseManager baseDatabaseManager;

    public CustomerManager(BaseDatabaseManager databaseManager){
        this.baseDatabaseManager=databaseManager;
    }
    public void getCustomer(){

        baseDatabaseManager.getData();
    }
}
