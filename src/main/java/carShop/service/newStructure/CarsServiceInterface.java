package carShop.service.newStructure;

import carShop.core.entity.Car;

import java.util.List;

/**
 * Created by employee on 11/2/15.
 */
public interface CarsServiceInterface {

    void addCar(Car car);
    void updateCar(Car car);
    void removeCar(Car car);
    List<Car> getCars();
    Car getCarById(int id);
}
