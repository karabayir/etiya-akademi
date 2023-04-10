package service.abstracts;

import entities.Car;

import java.util.List;

public interface CarService {

    List<Car> getAll();
    Car getById(int carId);
    Car getByPlate(String palate);
    void add(Car car);
    void update(int carId, Car updateCar);

    void delete(int carId);
}
