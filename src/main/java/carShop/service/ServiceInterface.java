package carShop.service;

import carShop.core.entity.Manager;

import java.time.LocalDate;

/**
 * Created by employee on 10/30/15.
 */
public interface ServiceInterface extends CarsServiceInterface, ManagersServiceInterface, DealsServiceInterface{
    void buyingCar(LocalDate localDate, int carId, int managerId);
    Manager getBestManager(LocalDate startDate, LocalDate endDate);
    boolean hasCars();
}
