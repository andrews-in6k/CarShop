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
    ControlInterfacesImplementer controlInterfacesImplementer = new ControlInterfacesImplementer();

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
        controlInterfacesImplementer.setOption(Options.OUTPUT_AVAILABLE_CARS);

        consoleCarShopController = new ConsoleCarShopController(
                controlInterfacesImplementer,
                controlInterfacesImplementer,
                controlInterfacesImplementer
        );

        consoleCarShopController.startManageCarShop();

        assertThat(controlInterfacesImplementer.getResultSet(), is(
                "printMainMenu " +
                "chooseMainMenuItem " +
                "getCars " +
                "printAvailableCars " +
                "printMainMenu " +
                "chooseMainMenuItem "
        ));
    }

    @Test
    public void testManageCarShopOutputManagers() {
        controlInterfacesImplementer.setOption(Options.OUTPUT_MANAGERS);

        consoleCarShopController = new ConsoleCarShopController(
                controlInterfacesImplementer,
                controlInterfacesImplementer,
                controlInterfacesImplementer
        );

        consoleCarShopController.startManageCarShop();

        assertThat(controlInterfacesImplementer.getResultSet(), is(
                "printMainMenu " +
                "chooseMainMenuItem " +
                "getSalesManagers " +
                "printSalesManagers " +
                "printMainMenu " +
                "chooseMainMenuItem "
        ));
    }

    @Test
    public void testManageCarShopOutputDeals() {
        controlInterfacesImplementer.setOption(Options.OUTPUT_DEALS);

        consoleCarShopController = new ConsoleCarShopController(
                controlInterfacesImplementer,
                controlInterfacesImplementer,
                controlInterfacesImplementer
        );

        consoleCarShopController.startManageCarShop();

        assertThat(controlInterfacesImplementer.getResultSet(), is(
                "printMainMenu " +
                "chooseMainMenuItem " +
                "getDeals " +
                "printDeals " +
                "printMainMenu " +
                "chooseMainMenuItem "
        ));
    }

    @Test
    public void testManageCarShopAddCar() {
        controlInterfacesImplementer.setOption(Options.ADD_CAR);

        consoleCarShopController = new ConsoleCarShopController(
                controlInterfacesImplementer,
                controlInterfacesImplementer,
                controlInterfacesImplementer
        );

        consoleCarShopController.startManageCarShop();

        assertThat(controlInterfacesImplementer.getResultSet(), is(
                "printMainMenu " +
                "chooseMainMenuItem " +
                "printInputBrand " +
                "inputString " +
                "printInputCarName " +
                "inputString " +
                "printInputCost " +
                "inputInteger " +
                "addCar " +
                "printMainMenu " +
                "chooseMainMenuItem "
        ));
    }

    @Test
    public void testManageCarShopAddManager() {
        controlInterfacesImplementer.setOption(Options.ADD_MANAGER);

        consoleCarShopController = new ConsoleCarShopController(
                controlInterfacesImplementer,
                controlInterfacesImplementer,
                controlInterfacesImplementer
        );

        consoleCarShopController.startManageCarShop();

        assertThat(controlInterfacesImplementer.getResultSet(), is(
                "printMainMenu " +
                "chooseMainMenuItem " +
                "printInputManagerName " +
                "inputString " +
                "printInputManagerSurname " +
                "inputString " +
                "addSalesManager " +
                "printMainMenu " +
                "chooseMainMenuItem "
        ));
    }

    @Test
    public void testManageCarShopBuyCar() {
        controlInterfacesImplementer.setOption(Options.BUY_CAR);

        consoleCarShopController = new ConsoleCarShopController(
                controlInterfacesImplementer,
                controlInterfacesImplementer,
                controlInterfacesImplementer
        );

        consoleCarShopController.startManageCarShop();

        assertThat(controlInterfacesImplementer.getResultSet(), is(
                "printMainMenu " +
                "chooseMainMenuItem " +
                "hasCars " +
                "printInputBuyingDate " +
                "inputString " +
                "getSalesManagers " +
                "printChooseManagerByNumber " +
                "getSalesManagers " +
                "printSalesManagers " +
                "inputInteger " +
                "getSalesManagers " +
                "getCars " +
                "printChooseCarByNumber " +
                "getCars " +
                "printAvailableCars " +
                "inputInteger " +
                "getCars " +
                "addDeal " +
                "printMainMenu " +
                "chooseMainMenuItem "
        ));
    }

    @Test
    public void testManageCarShopOutputBestManager() {
        controlInterfacesImplementer.setOption(Options.OUTPUT_BEST_MANAGER);

        consoleCarShopController = new ConsoleCarShopController(
                controlInterfacesImplementer,
                controlInterfacesImplementer,
                controlInterfacesImplementer
        );

        consoleCarShopController.startManageCarShop();

        assertThat(controlInterfacesImplementer.getResultSet(), is(
                "printMainMenu " +
                "chooseMainMenuItem " +
                "printInputStartDate " +
                "inputString " +
                "printInputEndDate " +
                "inputString " +
                "getBestSalesManager " +
                "printSalesManagerDeals " +
                "printMainMenu " +
                "chooseMainMenuItem "
        ));
    }
}
