package carShop.service.newStructure;

import carShop.core.dao.CarDAO;
import carShop.core.entity.Car;

import java.util.List;

/**
 * Created by employee on 11/2/15.
 */
public class CarsService implements CarsServiceInterface{

    private CarDAO carDAO;

    public CarsService(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @Override
    public void addCar(Car car) {
        carDAO.save(car);
    }

    @Override
    public void removeCar(Car car) {
        carDAO.delete(car);
    }

    @Override
    public List<Car> getCars() {
        return carDAO.getTableRows();
    }

    @Override
    public Car getCarById(int id) {
        return carDAO.getById(id);
    }
}
