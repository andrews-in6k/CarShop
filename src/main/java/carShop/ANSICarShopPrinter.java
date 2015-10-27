package carShop;

import carShop.core.entity.Car;
import carShop.core.entity.Deal;
import carShop.core.entity.Manager;

import java.io.PrintStream;
import java.time.ZoneId;
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
            if (car.getDeal() == null) {
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
    }

    public void printSalesManagers(List<Manager> managers) {
        printStream.println("Sales managers:");
        printStream.println("|  #|                  SURNAME|                NAME|");

        int i = 1;
        for (Manager manager : managers) {
            printStream.printf(
                    "|%3d|%25s|%20s|\n",
                    i,
                    manager.getLastName(),
                    manager.getFirstName()
            );

            i++;
        }
    }

    public void printDeals(List<Deal> deals) {
        printStream.println("Deals:");
        printStream.println(
                "|           DATE|" +
                "                                           MANAGER|" +
                "                                          SOLD CAR|"
        );

        for (Deal deal : deals) {


            printStream.printf(
                    "|%15s|%50s|%49s$|\n",
                    deal.getBuyingDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString(),
                    deal.getManager().getLastName() + " " + deal.getManager().getFirstName(),
                    deal.getSoldCar().getBrand() + " " + deal.getSoldCar().getName()+ " " + deal.getSoldCar().getCost()
            );
        }
    }

    public void printManagerDeals(Manager manager) {
        printStream.printf(manager.getLastName() + " " + manager.getFirstName() + " deals:\n");
        printStream.println("|           DATE|                                      SOLD CAR|");

        for (Deal deal : manager.getDeals()) {
            printStream.printf(
                    "|%15s|%45s$|\n",
                    deal.getBuyingDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString(),
                    deal.getSoldCar().getBrand() + " " + deal.getSoldCar().getName() + " " + deal.getSoldCar().getCost()
            );
        }
    }

    public void printMainMenu() {
        printStream.println("1 - output available cars");
        printStream.println("2 - output managers");
        printStream.println("3 - output deals");
        printStream.println("4 - add car");
        printStream.println("5 - add manager");
        printStream.println("6 - remove car");
        printStream.println("7 - remove manager");
        printStream.println("b - buy car");
        printStream.println("o - output best manager");
        printStream.println("e - exit");
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

    public void printChooseCarByNumber() {
        printStream.println("Choose car by number:");
    }

    public void printChooseManagerByNumber() {
        printStream.println("Choose manager by number:");
    }

    public void printInputBuyingDate() {
        printStream.println("Enter buying date(yyyy-mm-dd):");
    }

    public void printInputStartDate() {
        printStream.println("Enter start date(yyyy-mm-dd):");
    }

    public void printInputEndDate() {
        printStream.println("Enter end date(yyyy-mm-dd):");
    }

    public void printWrongSymbol() {
        printStream.println("Not available symbol");
    }
}
