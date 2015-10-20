package carShop;

import java.time.LocalDate;

/**
 * Created by employee on 10/20/15.
 */
public class Deal {
    private Car soldCar;
    private SalesManager salesManager;
    private LocalDate date;

    public Deal(LocalDate date, SalesManager salesManager, Car soldCar) {
        this.date = date;
        this.salesManager = salesManager;
        this.soldCar = soldCar;
    }

    public Car getSoldCar() {
        return soldCar;
    }

    public SalesManager getSalesManager() {
        return salesManager;
    }

    public LocalDate getDate() {
        return date;
    }
}
