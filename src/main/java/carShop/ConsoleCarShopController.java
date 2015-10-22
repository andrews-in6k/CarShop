package carShop;

import java.time.LocalDate;

/**
 * Created by anri on 20.10.15.
 */
public class ConsoleCarShopController implements CarShopController {

    CarShopInterface carShop;
    InputStream inputStream;
    CarShopPrinter carShopPrinter;
    Options option;

    public ConsoleCarShopController(CarShopInterface carShop, InputStream inputStream, CarShopPrinter carShopPrinter) {
        this.carShop = carShop;
        this.inputStream = inputStream;
        this.carShopPrinter = carShopPrinter;
    }

    public void startManageCarShop() {
        boolean isNotExit = true;

        while (isNotExit){
            carShopPrinter.printMainMenu();
            option = inputStream.chooseMainMenuItem();

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
        carShopPrinter.printSalesManagers(carShop.getSalesManagers());
    }

    private void outputDeals() {
        carShopPrinter.printDeals(carShop.getDeals());
    }

    private void addCar() {
        carShop.addCar(new Car(inputCarBrand(), inputCarName(), inputCarCost()));
    }

    private String inputCarBrand() {
        carShopPrinter.printInputBrand();
        return inputStream.inputString();
    }

    private String inputCarName() {
        carShopPrinter.printInputCarName();
        return inputStream.inputString();
    }

    private int inputCarCost() {
        carShopPrinter.printInputCost();
        return inputStream.inputInteger();
    }

    private void addManager() {
        removeDefaultManager();

        carShop.addSalesManager(new SalesManager(inputManagerName(), inputManagerSurname()));
    }

    private String inputManagerName() {
        carShopPrinter.printInputManagerName();
        return inputStream.inputString();
    }

    private String inputManagerSurname() {
        carShopPrinter.printInputManagerSurname();
        return inputStream.inputString();
    }

    private void removeDefaultManager() {
        if (carShop.hasDefault()) {
            carShop.removeSalesManager(carShop.getSalesManagers().get(0));
        }
    }

    private void buyingCar() {
        if (carShop.hasCars()) {
            Deal deal = new Deal(
                    inputBuyingDate(),
                    carShop.getSalesManagers().get(chooseManagerNumber()),
                    carShop.getCars().get(chooseCarNumber()));

            carShop.addDeal(deal);
        }
    }

    private int chooseCarNumber() {
        carShopPrinter.printChooseCarByNumber();
        outputAvailableCars();

        int inputInteger = inputStream.inputInteger() - 1;

        if ((inputInteger < 0) || (inputInteger >= carShop.getCars().size())) {
            return 0;
        }

        return inputInteger;
    }

    private int chooseManagerNumber() {
        carShopPrinter.printChooseManagerByNumber();
        outputSalesManagers();

        int inputInteger = inputStream.inputInteger() - 1;

        if ((inputInteger < 0) || (inputInteger >= carShop.getSalesManagers().size())) {
            return 0;
        }

        return inputInteger;
    }

    private LocalDate inputBuyingDate() {
        carShopPrinter.printInputBuyingDate();
        return getParsedDate();
    }

    private void outputBestManager() {
        carShopPrinter.printSalesManagerDeals(carShop.getBestSalesManager(inputStartDate(), inputEndDate()));
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
            return LocalDate.parse(inputStream.inputString());
        } catch (Exception e) {
            return LocalDate.now();
        }
    }
}
