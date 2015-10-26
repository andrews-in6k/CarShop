package carShop.dao;

import carShop.entity.Car;

import java.util.List;

/**
 * Created by employee on 10/23/15.
 */
public interface CarDAOInterface {

    List<Car> getCars();
    void removeCar(Object object);
    void addCar(Object object);
}
