package carShop;

import carShop.entity.Car;
import carShop.entity.Manager;
import carShop.service.CarShopServiceInterface;

import java.time.LocalDate;

/**
 * Created by anri on 20.10.15.
 */
public class ConsoleCarShopController implements CarShopController {

    CarShopServiceInterface carShop;
    CarShopInputStream carShopInputStream;
    CarShopPrinter carShopPrinter;
    Options option;

    public ConsoleCarShopController(CarShopServiceInterface carShop, CarShopInputStream carShopInputStream, CarShopPrinter carShopPrinter) {
        this.carShop = carShop;
        this.carShopInputStream = carShopInputStream;
        this.carShopPrinter = carShopPrinter;
    }

    public void startManageCarShop() {
        boolean isNotExit = true;

        while (isNotExit){
            carShopPrinter.printMainMenu();
            option = carShopInputStream.chooseMainMenuItem();

            switch (option){
                case OUTPUT_AVAILABLE_CARS:
                    outputAvailableCars();
                    break;
                case OUTPUT_MANAGERS:
                    outputSalesManagers();
                    break;
                case OUTPUT_DEALS:
                    outputDeals();
                    break;
                case ADD_CAR:
                    addCar();
                    break;
                case ADD_MANAGER:
                    addManager();
                    break;
                case BUY_CAR:
                    buyingCar();
                    break;
                case OUTPUT_BEST_MANAGER:
                    outputBestManager();
                    break;
                case EXIT:
                    isNotExit = false;
                    break;
            }

        }

    }

    private void outputAvailableCars() {
        carShopPrinter.printAvailableCars(carShop.getCars());
    }

    private void outputSalesManagers() {
        carShopPrinter.printSalesManagers(carShop.getManagers());
    }

    private void outputDeals() {
        carShopPrinter.printDeals(carShop.getDeals());
    }

    private void addCar() {
        Car car = new Car();

        car.setBrand(inputCarBrand());
        car.setName(inputCarName());
        car.setCost(inputCarCost());

        carShop.addCar(car);
    }

    private String inputCarBrand() {
        carShopPrinter.printInputBrand();
        return carShopInputStream.inputString();
    }

    private String inputCarName() {
        carShopPrinter.printInputCarName();
        return carShopInputStream.inputString();
    }

    private int inputCarCost() {
        carShopPrinter.printInputCost();
        return carShopInputStream.inputInteger();
    }

    private void addManager() {
        Manager manager = new Manager();

        manager.setFirstName(inputManagerName());
        manager.setLastName(inputManagerSurname());

        carShop.addManager(manager);
    }

    private String inputManagerName() {
        carShopPrinter.printInputManagerName();
        return carShopInputStream.inputString();
    }

    private String inputManagerSurname() {
        carShopPrinter.printInputManagerSurname();
        return carShopInputStream.inputString();
    }

    private void buyingCar() {
        if (carShop.hasCars()) {
            carShop.buyingCar(inputBuyingDate(), chooseManagerNumber(), chooseCarNumber());
        }
    }

    private int chooseManagerNumber() {
        carShopPrinter.printChooseManagerByNumber();
        outputSalesManagers();

        int inputInteger = carShopInputStream.inputInteger() - 1;

        if ((inputInteger < 0) || (inputInteger >= carShop.getManagers().size())) {
            return 0;
        }

        return inputInteger;
    }

    private int chooseCarNumber() {
        carShopPrinter.printChooseCarByNumber();
        outputAvailableCars();

        int inputInteger = carShopInputStream.inputInteger() - 1;

        if ((inputInteger < 0) || (inputInteger >= carShop.getCars().size())) {
            return 0;
        }

        return inputInteger;
    }

    private LocalDate inputBuyingDate() {
        carShopPrinter.printInputBuyingDate();
        return getParsedDate();
    }

    private void outputBestManager() {
        carShopPrinter.printSalesManagerDeals(carShop.getBestManager(inputStartDate(), inputEndDate()));
    }

    private LocalDate inputStartDate() {
        carShopPrinter.printInputStartDate();
        return getParsedDate();
    }

    private LocalDate inputEndDate() {
        carShopPrinter.printInputEndDate();
        return getParsedDate();
    }

    private LocalDate getParsedDate() {
        try {
            return LocalDate.parse(carShopInputStream.inputString());
        } catch (Exception e) {
            return LocalDate.now();
        }
    }
}
