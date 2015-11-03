package carShop.consoleCarShopHandlers;

import carShop.core.entity.Car;
import carShop.core.entity.Manager;
import carShop.service.ServiceInterface;

import java.time.LocalDate;

/**
 * Created by anri on 20.10.15.
 */
public class ConsoleCarShopController implements CarShopController {

    ServiceInterface carShopService;
    CarShopInputStream carShopInputStream;
    CarShopPrinter carShopPrinter;
    Options option;

    public ConsoleCarShopController(ServiceInterface carShopService,
                                    CarShopInputStream carShopInputStream,
                                    CarShopPrinter carShopPrinter) {
        this.carShopService = carShopService;
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
                case REMOVE_CAR:
                    removeCarByNumber();
                    break;
                case REMOVE_MANAGER:
                    removeManagerByNumber();
                    break;
                case OUTPUT_BEST_MANAGER:
                    outputBestManager();
                    break;
                case EXIT:
                    isNotExit = false;
                    break;
                case OTHER:
                    carShopPrinter.printWrongSymbol();
            }

        }

    }

    private void outputAvailableCars() {
        carShopPrinter.printAvailableCars(carShopService.getCars());
    }

    private void outputSalesManagers() {
        carShopPrinter.printSalesManagers(carShopService.getManagers());
    }

    private void outputDeals() {
        carShopPrinter.printDeals(carShopService.getDeals());
    }

    private void addCar() {
        Car car = new Car();

        car.setBrand(inputCarBrand());
        car.setName(inputCarName());
        car.setCost(inputCarCost());

        carShopService.addCar(car);
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

        carShopService.addManager(manager);
    }

    private String inputManagerName() {
        carShopPrinter.printInputManagerName();
        return carShopInputStream.inputString();
    }

    private String inputManagerSurname() {
        carShopPrinter.printInputManagerSurname();
        return carShopInputStream.inputString();
    }

    private void removeCarByNumber() {
        carShopPrinter.printChooseCarByNumber();
        carShopService.removeCarById(chooseCarId());
    }

    private void removeManagerByNumber() {
        carShopPrinter.printChooseManagerByNumber();
        carShopService.removeManagerById(chooseManagerId());
    }

    private void buyingCar() {
        if (carShopService.hasCars()) {
            carShopService.buyingCar(inputBuyingDate(), chooseCarId(), chooseManagerId());
        }
    }

    private int chooseCarId() {
        carShopPrinter.printChooseCarByNumber();
        outputAvailableCars();

        int inputInteger = carShopInputStream.inputInteger();

        int index = 0;
        for (Car car : carShopService.getCars()) {
            if (car.getDeal() == null) {
                index++;
            }
            if (index == inputInteger) {
                return car.getId();
            }
        }

        return 0;
    }

    private int chooseManagerId() {
        carShopPrinter.printChooseManagerByNumber();
        outputSalesManagers();

        int inputInteger = carShopInputStream.inputInteger();

        int index = 0;

        for (Manager manager : carShopService.getManagers()) {
            index++;
            if (index == inputInteger) {
                return manager.getId();
            }
        }

        return 0;
    }

    private LocalDate inputBuyingDate() {
        carShopPrinter.printInputBuyingDate();
        return getParsedDate();
    }

    private void outputBestManager() {
        carShopPrinter.printManagerDeals(carShopService.getBestManager(inputStartDate(), inputEndDate()));
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
