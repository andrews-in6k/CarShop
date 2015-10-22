package carShop;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by anri on 20.10.15.
 */
public class ANSICarShopPrinterTest {

    ANSICarShopPrinter ansiCarShopPrinter;
    CarShop carShop;

    PrintStream printStream;
    OutputStream outputStream;

    @Before
    public void setUp() {
        carShop = new CarShop();
        outputStream = new ByteArrayOutputStream();
        printStream = new PrintStream(outputStream);
        ansiCarShopPrinter = new ANSICarShopPrinter(printStream);
    }

    @Test
    public void testPrintAvailableCarsEmptyList() {
        ansiCarShopPrinter.printAvailableCars(carShop.getCars());

        assertThat(outputStream.toString(), is(
                "Available cars:\n" +
                "|  #|               BRAND|           NAME|        COST($)|\n"
        ));
    }

    @Test
    public void testPrintAvailableCarsList() {
        carShop.addCar(new Car("BMW", "Z4", 50000));
        carShop.addCar(new Car("BMW", "M3", 65000));

        ansiCarShopPrinter.printAvailableCars(carShop.getCars());

        assertThat(outputStream.toString(), is(
                "Available cars:\n" +
                "|  #|               BRAND|           NAME|        COST($)|\n" +
                "|  1|                 BMW|             Z4|          50000|\n" +
                "|  2|                 BMW|             M3|          65000|\n"
        ));
    }

    @Test
    public void testPrintEmptySalesManagers() {
        ansiCarShopPrinter.printSalesManagers(Collections.emptyList());

        assertThat(outputStream.toString(), is(
                "Sales managers:\n" +
                "|  #|                  SURNAME|                NAME|\n"
        ));
    }

    @Test
    public void testPrintSalesManagers() {
        carShop.addSalesManager(new SalesManager("Alex", "Svirzevskiy"));
        carShop.addSalesManager(new SalesManager("Bogdan", "Jarmul"));

        ansiCarShopPrinter.printSalesManagers(carShop.getSalesManagers());

        assertThat(outputStream.toString(), is(
                "Sales managers:\n" +
                "|  #|                  SURNAME|                NAME|\n" +
                "|  1|              Svirzevskiy|                Alex|\n" +
                "|  2|                   Jarmul|              Bogdan|\n"
        ));
    }

    @Test
    public void testPrintEmptyDeals() {
        ansiCarShopPrinter.printDeals(carShop.getDeals());

        assertThat(outputStream.toString(), is(
                "Deals:\n" +
                "|           DATE|" +
                "                                            MANAGER|" +
                "                                       SOLD CAR|\n"
        ));
    }

    @Test
    public void testPrintDeals() {
        LocalDate date = LocalDate.of(2015, 2, 5);
        SalesManager salesManager = new SalesManager("Anton", "Pupko");
        Car car = new Car("Peugeot", "306", 15000);

        carShop.addDeal(new Deal(date, salesManager, car));

        ansiCarShopPrinter.printDeals(carShop.getDeals());

        assertThat(outputStream.toString(), is(
                "Deals:\n" +
                "|           DATE|" +
                "                                            MANAGER|" +
                "                                       SOLD CAR|\n" +
                "|     2015-02-05|" +
                "                         Pupko|               Anton|" +
                "          Peugeot|             306|      15000$|\n"
        ));
    }

    @Test
    public void testPrintEmptySalesManagerDeals() {
        ansiCarShopPrinter.printSalesManagerDeals(carShop.getSalesManagers().get(0));

        assertThat(outputStream.toString(), is(
                "Default Manager deals:\n" +
                "|           DATE|" +
                "                                     SOLD CAR|\n"
        ));
    }

    @Test
    public void testPrintSalesManagerDeals() {
        SalesManager salesManager = new SalesManager("Anton", "Pupko");

        LocalDate date = LocalDate.of(2015, 2, 5);
        Car car = new Car("Peugeot", "306", 15000);

        salesManager.addDeal(new Deal(date, salesManager, car));

        carShop.addSalesManager(salesManager);

        ansiCarShopPrinter.printSalesManagerDeals(carShop.getSalesManagers().get(0));

        assertThat(outputStream.toString(), is(
                "Pupko Anton deals:\n" +
                "|           DATE|" +
                "                                     SOLD CAR|\n" +
                "|     2015-02-05|" +
                "          Peugeot             306      15000$|\n"
        ));
    }
}
