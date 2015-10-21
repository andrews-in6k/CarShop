package carShop;

import java.util.List;

/**
 * Created by employee on 10/21/15.
 */
public class ControllInterfacesImplementer implements CarShopPrinter, InputStream, CarShopInterface{

    private String resultSet = "";
    private Options option;

    public void setOption(Options option) {
        this.option = option;
    }

    public String getResultSet() {
        return resultSet;
    }

    //CarShopInterface
    public void addDeal(Deal deal) {
        resultSet += "addDeal ";
    }

    public void addCar(Car car) {
        resultSet += "addCar ";
    }

    public void addSalesManager(SalesManager salesManager) {
        resultSet += "addSalesManager ";
    }

    public void removeCar(Car car) {
        resultSet += "removeCar ";
    }

    public void removeSalesManager(SalesManager salesManager) {
        resultSet += "removeSalesManager ";
    }

    public List<Car> getCars() {
        resultSet += "getCars ";
        return null;
    }

    public List<SalesManager> getSalesManagers() {
        resultSet += "getSalesManagers ";
        return null;
    }

    public List<Deal> getDeals() {
        resultSet += "getDeals ";
        return null;
    }

    //ConsoleInputStream
    public Options chooseMainMenuItem() {
        resultSet += "chooseMainMenuItem ";
        return option;
    }

    public String inputString() {
        resultSet += "inputString ";
        return null;
    }

    public int inputInteger() {
        resultSet += "inputInteger ";
        return 0;
    }

    //CarShopPrinter
    public void printAvailableCars(List<Car> cars) {
        resultSet += "printAvailableCars ";
    }

    public void printSalesManagers(List<SalesManager> salesManagers) {
        resultSet += "printSalesManagers";
    }

    public void printDeals(List<Deal> deals) {
        resultSet += "printDeals ";
    }

    public void printSalesManagerDeals(SalesManager salesManager) {
        resultSet += "printSalesManagerDeals ";
    }

    public void printMainMenu() {
        resultSet += "printMainMenu ";
    }

    public void printInputBrand() {
        resultSet += "printInputBrand ";
    }

    public void printInputCarName() {
        resultSet += "printInputCarName ";
    }

    public void printInputCost() {
        resultSet += "printInputCost ";
    }

    public void printInputManagerName() {
        resultSet += "printInputManagerName ";
    }

    public void printInputManagerSurname() {
        resultSet += "printInputManagerSurname ";
    }

    public void printChooseCarByNumber() {
        resultSet += "printChooseCarByNumber ";
    }

    public void printChooseManagerByNumber() {
        resultSet += "printChooseManagerByNumber ";
    }

    public void printInputBuyingDate() {
        resultSet += "printInputBuyingDate ";
    }

    public void printInputStartDate() {
        resultSet += "printInputStartDate ";
    }

    public void printInputEndDate() {
        resultSet += "printInputEndDate ";
    }
}
