package carShop;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Scanner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by anri on 20.10.15.
 */
public class ConsoleCarShopControllerTest {

    ConsoleCarShopController consoleCarShopController;
    ControllInterfacesImplementer controllInterfacesImplementer = new ControllInterfacesImplementer();

    @Test
    public void testCreateConsoleCarShopController() {
        PrintStream printStream = new PrintStream(System.out);
        Scanner scanner = new Scanner(System.in);

        InputStream inputStream = new ConsoleInputStream(scanner);
        CarShopPrinter carShopPrinter = new ANSICarShopPrinter(printStream);

        new ConsoleCarShopController(new CarShop(), inputStream, carShopPrinter);
    }

    @Test
    public void testManageCarShopOutputAvailableCars() {
        controllInterfacesImplementer.setOption(Options.OUTPUT_AVAILABLE_CARS);

        consoleCarShopController = new ConsoleCarShopController(
                controllInterfacesImplementer,
                controllInterfacesImplementer,
                controllInterfacesImplementer
        );

        consoleCarShopController.startManageCarShop();

        assertThat(controllInterfacesImplementer.getResultSet(), is("printAvailableCars "));

        controllInterfacesImplementer.setOption(Options.EXIT);
    }
}
