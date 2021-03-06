//package carShop;
//
//import carShop.service.consoleCarShopHandlers.CarShopServiceInterface;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by employee on 10/21/15.
// */
//public class ControlInterfacesImplementer implements CarShopPrinter, CarShopInputStream, CarShopServiceInterface {
//
//    private String resultSet = "";
//    private Options option = Options.EXIT;
//    private boolean iterationFlag = false;
//    private List<Car> cars = new ArrayList<>();
//    private List<SalesManager> salesManagers = new ArrayList<>();
//    private List<Deal> deals = new ArrayList<>();
//
//    public void setOption(Options option) {
//        cars.add(new Car("Porshe", "911", 95000));
//        salesManagers.add(new SalesManager("name", "surname"));
//        deals.add(new Deal(LocalDate.now(), salesManagers.get(0), cars.get(0)));
//
//        iterationFlag = false;
//        this.option = option;
//    }
//
//    public String getResultSet() {
//        return resultSet;
//    }
//
//    //CarShopServiceInterface
//    public boolean hasDefault(){
//        resultSet += "hasDefault ";
//
//        return false;
//    }
//
//    public boolean hasCars(){
//        resultSet += "hasCars ";
//
//        return true;
//    }
//
//    public void addDeal(Deal deal) {
//        resultSet += "addDeal ";
//    }
//
//    public void buyingCar(LocalDate buyingDate, int inputIntegerManager, int inputIntegerCar) {
//        resultSet += "buyingCar ";
//    }
//
//    public SalesManager getBestSalesManager(LocalDate startDate, LocalDate endDate) {
//        resultSet += "getBestSalesManager ";
//
//        return null;
//    }
//
//    public void addCar(Car car) {
//        resultSet += "saveCar ";
//    }
//
//    public void addSalesManager(SalesManager salesManager) {
//        resultSet += "addSalesManager ";
//    }
//
//    public void removeCar(Car car) {
//        resultSet += "deleteCar ";
//    }
//
//    public void removeSalesManager(SalesManager salesManager) {
//        resultSet += "removeSalesManager ";
//    }
//
//    public List<Car> getCars() {
//        resultSet += "getCars ";
//
//        return cars;
//    }
//
//    public List<SalesManager> getSalesManagers() {
//        resultSet += "getSalesManagers ";
//
//        return salesManagers;
//    }
//
//    public List<Deal> getDeals() {
//        resultSet += "getDeals ";
//
//        return deals;
//    }
//
//    //ConsoleCarShopInputStream
//    public Options chooseMainMenuItem() {
//        resultSet += "chooseMainMenuItem ";
//
//        if (iterationFlag) {
//            return Options.EXIT;
//        }
//
//        iterationFlag = true;
//        return option;
//    }
//
//    public String inputString() {
//        resultSet += "inputString ";
//        return null;
//    }
//
//    public int inputInteger() {
//        resultSet += "inputInteger ";
//        return 1;
//    }
//
//    //CarShopPrinter
//    public void printAvailableCars(List<Car> cars) {
//        resultSet += "printAvailableCars ";
//    }
//
//    public void printSalesManagers(List<SalesManager> salesManagers) {
//        resultSet += "printSalesManagers ";
//    }
//
//    public void printDeals(List<Deal> deals) {
//        resultSet += "printDeals ";
//    }
//
//    public void printManagerDeals(SalesManager salesManager) {
//        resultSet += "printManagerDeals ";
//    }
//
//    public void printMainMenu() {
//        resultSet += "printMainMenu ";
//    }
//
//    public void printInputBrand() {
//        resultSet += "printInputBrand ";
//    }
//
//    public void printInputCarName() {
//        resultSet += "printInputCarName ";
//    }
//
//    public void printInputCost() {
//        resultSet += "printInputCost ";
//    }
//
//    public void printInputManagerName() {
//        resultSet += "printInputManagerName ";
//    }
//
//    public void printInputManagerSurname() {
//        resultSet += "printInputManagerSurname ";
//    }
//
//    public void printChooseCarByNumber() {
//        resultSet += "printChooseCarByNumber ";
//    }
//
//    public void printChooseManagerByNumber() {
//        resultSet += "printChooseManagerByNumber ";
//    }
//
//    public void printInputBuyingDate() {
//        resultSet += "printInputBuyingDate ";
//    }
//
//    public void printInputStartDate() {
//        resultSet += "printInputStartDate ";
//    }
//
//    public void printInputEndDate() {
//        resultSet += "printInputEndDate ";
//    }
//}
