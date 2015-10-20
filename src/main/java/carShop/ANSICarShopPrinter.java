package carShop;

import java.io.PrintStream;
import java.util.List;

/**
 * Created by anri on 20.10.15.
 */
public class ANSICarShopPrinter implements CarShopPrinter{

    PrintStream printStream;

    public ANSICarShopPrinter(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void printAvailableCars(List<Car> cars){
        printStream.println("Available cars:");
        printStream.println("|               BRAND|           NAME|        COST($)|");
        for (int i = 0; i < cars.size(); i++) {
            printStream.printf(
                    "|%20s|%15s|%15s|\n",
                    cars.get(i).getBrand(),
                    cars.get(i).getName(),
                    cars.get(i).getCost()
            );
        }
    }

    public void printSalesManagers(List<SalesManager> salesManagers){
        printStream.println("Sales managers:");
        printStream.println("|                  SURNAME|                NAME|");
        for (int i = 0; i < salesManagers.size(); i++) {
            printStream.printf(
                    "|%25s|%20s|\n",
                    salesManagers.get(i).getSurname(),
                    salesManagers.get(i).getName()
            );
        }
    }

    public void printDeals(List<Deal> deals){

    }

    public void printSalesManagerDeals(SalesManager salesManager) {

    }
}
