package carShop;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by anri on 20.10.15.
 */
public class ConsoleCarShopController implements CarShopController {

    CarShop carShop;
    InputStream inputStream;
    CarShopPrinter carShopPrinter;
    Options options;

    public ConsoleCarShopController(CarShop carShop, InputStream inputStream, CarShopPrinter carShopPrinter) {
        this.carShop = carShop;
        this.inputStream = inputStream;
        this.carShopPrinter = carShopPrinter;
    }

    public void startManageCarShop() {
        boolean isNotExit = true;

        while (isNotExit){
            carShopPrinter.printMainMenu();
            options = inputStream.chooseMainMenuItem();

            switch (options){
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
        carShopPrinter.printInputBrand();
        String brand = inputStream.inputString();

        carShopPrinter.printInputCarName();
        String carName = inputStream.inputString();

        carShopPrinter.printInputCost();
        int cost = inputStream.inputInteger();

        carShop.addCar(new Car(brand, carName, cost));
    }

    private void addManager() {
        carShopPrinter.printInputManagerName();
        String name = inputStream.inputString();

        carShopPrinter.printInputManagerSurname();
        String surname = inputStream.inputString();

        if (carShop.getSalesManagers().get(0).getSurname().equals("Default")) {
            carShop.removeSalesManager(carShop.getSalesManagers().get(0));
        }

        carShop.addSalesManager(new SalesManager(name, surname));
    }

    private void buyingCar() {
        carShopPrinter.printChooseCarByNumber();
        outputAvailableCars();
        int carIndex = inputStream.inputInteger() - 1;

        carShopPrinter.printChooseManagerByNumber();
        outputSalesManagers();
        int managerIndex = inputStream.inputInteger() - 1;

        carShopPrinter.printInputBuyingDate();
        LocalDate date = getParsedDate();

        Deal deal = new Deal(date, carShop.getSalesManagers().get(managerIndex), carShop.getCars().get(carIndex));

        carShop.addDeal(deal);
    }

    private void outputBestManager() {
        carShopPrinter.printInputStartDate();
        LocalDate startDate = getParsedDate();

        carShopPrinter.printInputEndDate();
        LocalDate endDate = getParsedDate();

        SalesManager bestSalesManager = carShop.getSalesManagers().get(0);
        int maxDealsCount = 0;
        for (SalesManager salesManager : carShop.getSalesManagers()) {
            int pretendingMaxDealsCount = 0;
            for (Deal deal : salesManager.getDeals()) {
                if (deal.getDate().isAfter(startDate) && deal.getDate().isBefore(endDate)) {
                    pretendingMaxDealsCount++;
                }
            }
            if (pretendingMaxDealsCount > maxDealsCount) {
                bestSalesManager = salesManager;
                maxDealsCount = pretendingMaxDealsCount;
            }
        }

        carShopPrinter.printSalesManagerDeals(bestSalesManager);
    }

    private LocalDate getParsedDate() {
        try {
            return LocalDate.parse(inputStream.inputString());
        } catch (Exception e) {
            return LocalDate.now();
        }
    }
}
