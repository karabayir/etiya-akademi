import entities.Brand;
import entities.Car;
import entities.CarState;
import entities.Model;
import repository.InMemoryBrand;
import repository.InMemoryCar;
import repository.InMemoryModel;
import service.concretes.BrandManager;
import service.concretes.CarManager;
import service.concretes.ModelManager;

public class Main {
    public static void main(String[] args) {

        CarManager carManager = new CarManager(new InMemoryCar());
        ModelManager modelManager = new ModelManager(new InMemoryModel());
        BrandManager brandManager = new BrandManager(new InMemoryBrand());

        Model model1 = new Model(1,"5.20");
        Model model2 = new Model(2,"egea");
        Model model3 = new Model(2,"c-suv");

        Brand brand1 = new Brand(1,"BMW");
        Brand brand2 = new Brand(2,"FIAT");
        Brand brand3 = new Brand(3,"TOGG");

        Car car1 =  new Car(1,"41 AB 2023",2020,800, CarState.AVAILABLE,model1.getId(),brand1.getId());
        Car car1update =  new Car(1,"41 AB 2023",2021,850, CarState.AVAILABLE,model1.getId(),brand1.getId());
        Car car2 =  new Car(2,"41 BA 2023",2020,500, CarState.AVAILABLE,model2.getId(),brand2.getId());
        Car car3 =  new Car(3,"41 ABC 2023",2020,1000, CarState.AVAILABLE,model3.getId(),brand3.getId());

        modelManager.add(model1);
        modelManager.add(model2);
        modelManager.add(model3);


        brandManager.add(brand1);
        brandManager.add(brand2);
        brandManager.add(brand3);



        carManager.add(car1);
        carManager.add(car2);
        carManager.add(car3);
       // carManager.update(1,car1update);
       // carManager.delete(3);

        System.out.println("-------------------MODELLER---------------------");

        for(Model model : modelManager.getAll())
            System.out.println(model.getId()+" "+model.getName());

        System.out.println("-------------------MARKALAR---------------------");

        for (Brand brand : brandManager.getAll())
            System.out.println(brand.getId()+" "+brand.getName());

        System.out.println("-------------------ARABALAR---------------------");

        for (Car car : carManager.getAll())
            System.out.println(
                    car.getId()+" "+
                            car.getPlate()+" "+
                            car.getDailyPrice()+" "+
                            car.getModelYear()+" "+
                            car.getCarState()+" "+
                            car.getModelId()+" "+
                            car.getBrandId());

        System.out.println("-------------------GET BY ---------------------");
        System.out.println(modelManager.getById(1).getId()+" "+ modelManager.getByName("5.20").getName());
        System.out.println(brandManager.getById(1).getId()+" "+ brandManager.getByName("BMW").getName());
        System.out.println(carManager.getById(1).getId()+" "+ carManager.getByPlate("41 AB 2023").getPlate());
    }
}