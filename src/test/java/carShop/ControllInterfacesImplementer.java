package carShop;

import java.util.List;

/**
 * Created by employee on 10/21/15.
 */
public class ControllInterfacesImplementer implements CarShopPrinter, InputStream, CarShopInterface{

    //CarShopInterface
    public void addDeal(Deal deal) {

    }

    public void addCar(Car car) {

    }

    public void addSalesManager(SalesManager salesManager) {

    }

    public void removeCar(Car car) {

    }

    public void removeSalesManager(SalesManager salesManager) {

    }

    public List<Car> getCars() {
        return null;
    }

    public List<SalesManager> getSalesManagers() {
        return null;
    }

    public List<Deal> getDeals() {
        return null;
    }

    //ConsoleInputStream
    public Options chooseMainMenuItem() {
        return null;
    }

    public String inputString() {
        return null;
    }

    public int inputInteger() {
        return 0;
    }

    //CarShopPrinter
    public void printAvailableCars(List<Car> cars) {

    }

    public void printSalesManagers(List<SalesManager> salesManagers) {

    }

    public void printDeals(List<Deal> deals) {

    }

    public void printSalesManagerDeals(SalesManager salesManager) {

    }

    public void printMainMenu() {

    }

    public void printInputBrand() {

    }

    public void printInputCarName() {

    }

    public void printInputCost() {

    }

    public void printInputManagerName() {

    }

    public void printInputManagerSurname() {

    }

    public void printChooseCarByNumber() {

    }

    public void printChooseManagerByNumber() {

    }

    public void printInputBuyingDate() {

    }

    public void printInputStartDate() {

    }

    public void printInputEndDate() {

    }
}
