package carShop;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by anri on 20.10.15.
 */
public class ANSICarShopPrinterTest {

    ANSICarShopPrinter ansiCarShopPrinter;
    CarShop carShop;

    PrintStream printStream;
    ByteArrayOutputStream baos;

    @Before
    public void setUp() {
        carShop = new CarShop();
        baos = new ByteArrayOutputStream();
        printStream = new PrintStream(baos);
        ansiCarShopPrinter = new ANSICarShopPrinter(printStream);
    }

    @Test
    public void testCreateANSICarShopPrinter() {
        new ANSICarShopPrinterTest();
    }

    @Test
    public void testPrintAvailableCarsEmptyList() {
        ansiCarShopPrinter.printAvailableCars(carShop.getCars());

        assertThat(baos.toString(), is(
                "Available cars:\n" +
                "|               BRAND|           NAME|        COST($)|\n"
        ));
    }

    @Test
    public void testPrintAvailableCarsList() {
        carShop.addCar(new Car("BMW", "Z4", 50000));
        carShop.addCar(new Car("BMW", "M3", 65000));

        ansiCarShopPrinter.printAvailableCars(carShop.getCars());

        assertThat(baos.toString(), is(
                "Available cars:\n" +
                "|               BRAND|           NAME|        COST($)|\n" +
                "|                 BMW|             Z4|          50000|\n" +
                "|                 BMW|             M3|          65000|\n"
        ));
    }

    @Test
    public void testPrintEmptySalesManagers() {
        ansiCarShopPrinter.printSalesManagers(carShop.getSalesManagers());

        assertThat(baos.toString(), is(
                "Sales managers:\n" +
                "|                  SURNAME|                NAME|\n"
        ));
    }

    @Test
    public void testPrintSalesManagers() {
        carShop.addSalesManager(new SalesManager("Alex", "Svirzevskiy"));
        carShop.addSalesManager(new SalesManager("Bogdan", "Jarmul"));

        ansiCarShopPrinter.printSalesManagers(carShop.getSalesManagers());

        assertThat(baos.toString(), is(
                "Sales managers:\n" +
                "|                  SURNAME|                NAME|\n" +
                "|              Svirzevskiy|                Alex|\n" +
                "|                   Jarmul|              Bogdan|\n"
        ));
    }
}
