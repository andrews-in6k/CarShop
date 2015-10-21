package carShop;

import java.io.PrintStream;
import java.util.List;

/**
 * Created by anri on 20.10.15.
 */
public class ANSICarShopPrinter implements CarShopPrinter {

    PrintStream printStream;

    public ANSICarShopPrinter(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void printAvailableCars(List<Car> cars) {
        printStream.println("Available cars:");
        printStream.println("|  #|               BRAND|           NAME|        COST($)|");

        int i = 1;
        for (Car car : cars) {
            printStream.printf(
                    "|%3d|%20s|%15s|%15s|\n",
                    i,
                    car.getBrand(),
                    car.getName(),
                    car.getCost()
            );

            i++;
        }
    }

    public void printSalesManagers(List<SalesManager> salesManagers) {
        printStream.println("Sales managers:");
        printStream.println("|  #|                  SURNAME|                NAME|");

        int i = 1;
        for (SalesManager salesManager : salesManagers) {
            printStream.printf(
                    "|%3d|%25s|%20s|\n",
                    i,
                    salesManager.getSurname(),
                    salesManager.getName()
            );

            i++;
        }
    }

    public void printDeals(List<Deal> deals) {
        printStream.println("Deals:");
        printStream.println(
                "|           DATE|" +
                "                                           MANAGER|" +
                "                                     SOLD CAR|"
        );

        for (Deal deal : deals) {
            printStream.printf(
                    "|%15s|%30s%20s|%17s%16s%11d$|\n",
                    deal.getDate().toString(),
                    deal.getSalesManager().getSurname(),
                    deal.getSalesManager().getName(),
                    deal.getSoldCar().getBrand(),
                    deal.getSoldCar().getName(),
                    deal.getSoldCar().getCost()
            );
        }
    }

    public void printSalesManagerDeals(SalesManager salesManager) {
        printStream.printf("%30s%20s     deals:\n", salesManager.getSurname(), salesManager.getName());
        printStream.println(
                "|           DATE|" +
                "                                     SOLD CAR|"
        );

        for (Deal deal : salesManager.getDeals()) {
            printStream.printf(
                    "|%15s|%17s%16s%11d$|\n",
                    deal.getDate().toString(),
                    deal.getSoldCar().getBrand(),
                    deal.getSoldCar().getName(),
                    deal.getSoldCar().getCost()
            );
        }
    }

    public void printMainMenu() {
        printStream.println("1 - output available cars");
        printStream.println("2 - output managers");
        printStream.println("3 - output list");
        printStream.println("4 - add car");
        printStream.println("5 - add manager");
        printStream.println("6 - buy car");
        printStream.println("7 - output best manager");
    }

    public void printInputBrand() {
        printStream.println("Enter car brand:");
    }

    public void printInputCarName() {
        printStream.println("Enter car name:");
    }

    public void printInputCost() {
        printStream.println("Enter car cost:");
    }

    public void printInputManagerName() {
        printStream.println("Enter manager name:");
    }

    public void printInputManagerSurname() {
        printStream.println("Enter manager surname:");
    }

    public void printInputStartDate() {
        printStream.println("Enter start date:");
    }

    public void printInputEndDate() {
        printStream.println("Enter end date:");
    }
}
