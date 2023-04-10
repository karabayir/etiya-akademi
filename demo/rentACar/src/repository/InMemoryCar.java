package repository;

import entities.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryCar {

    List<Car> cars = new ArrayList<>();

    public List<Car> getAll(){
        return  cars;
    }

    public void add(Car car){
        cars.add(car);
        System.out.println(car.getId()+" numaralı araç eklendi");
    }
    public void update(int carId, Car updateCar){
        Car car = findById(carId).orElseThrow();
        cars.set(cars.indexOf(car),updateCar);
        System.out.println(carId+" numaralı araç güncellendi");
    }

    public void delete(int carId){
        Car car = findById(carId).orElseThrow();
        cars.remove(cars.indexOf(car));
        System.out.println(carId+" numaralı araç kaldırıldı");
    }


    public Optional<Car>  findById(int carId){
       return cars.stream()
                .filter(c -> c.getId() == carId)
                .findAny();
    }
    public Optional<Car> findByPlate(String plate){
        return cars.stream()
                .filter(c -> c.getPlate().equals(plate))
                .findAny();
    }
}
