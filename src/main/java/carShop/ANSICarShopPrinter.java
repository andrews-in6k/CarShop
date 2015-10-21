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
        printStream.println("|               BRAND|           NAME|        COST($)|");

        for (Car car : cars) {
            printStream.printf(
                    "|%20s|%15s|%15s|\n",
                    car.getBrand(),
                    car.getName(),
                    car.getCost()
            );
        }
    }

    public void printSalesManagers(List<SalesManager> salesManagers) {
        printStream.println("Sales managers:");
        printStream.println("|                  SURNAME|                NAME|");

        for (SalesManager salesManager : salesManagers) {
            printStream.printf(
                    "|%25s|%20s|\n",
                    salesManager.getSurname(),
                    salesManager.getName()
            );
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
}
