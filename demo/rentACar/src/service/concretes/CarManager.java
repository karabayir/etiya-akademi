package service.concretes;

import entities.Car;
import repository.InMemoryCar;
import service.abstracts.CarService;

import java.util.List;

public class CarManager implements CarService {

    private InMemoryCar inMemoryCar;

    public CarManager(InMemoryCar inMemoryCar) {
        this.inMemoryCar = inMemoryCar;
    }

    @Override
    public List<Car> getAll() {
        return inMemoryCar.getAll();
    }

    @Override
    public Car getById(int carId) {
        return inMemoryCar.findById(carId).orElseThrow();
    }

    @Override
    public Car getByPlate(String palate) {
        return inMemoryCar.findByPlate(palate).orElseThrow();
    }

    @Override
    public void add(Car car) {
        checkIfPlateExists(car.getPlate());
        checkIfModelYearValid(car.getModelYear());
        checkIfPlateLengthValid(car.getPlate());
        inMemoryCar.add(car);
    }

    @Override
    public void update(int carId, Car updateCar) {
        checkIfCarExists(carId);
        checkIfPlateLengthValid(updateCar.getPlate());
        checkIfModelYearValid(updateCar.getModelYear());
        inMemoryCar.update(carId,updateCar);
    }

    @Override
    public void delete(int carId) {
        checkIfCarExists(carId);
        inMemoryCar.delete(carId);
    }

    private void checkIfCarExists(int carId){
        if(inMemoryCar.findById(carId).isEmpty())
            throw new RuntimeException(carId+" numaralı araç bulunamadı");
    }
    private void checkIfPlateExists(String plate){
        if(inMemoryCar.findByPlate(plate).isPresent())
            throw  new RuntimeException(plate+" plakalı araç zaten mevcuttur");
    }

    private void checkIfPlateLengthValid(String plate){
        int plateLength=plate.trim().replaceAll("\\s+","").length();
        if(plateLength < 6 || plateLength > 9)
            throw new RuntimeException(plate+" geçersiz plaka ");
    }

    private void checkIfModelYearValid(int modelYear){
        if(modelYear < 2018 || modelYear > 2023)
            throw new RuntimeException(modelYear+" geçersiz model yılı");
    }
}
