package carShop;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by anri on 20.10.15.
 */
public class ConsoleCarShopControllerTest {

    @Test
    public void testCreateConsoleCarShopController() {
        PrintStream printStream = new PrintStream(System.out);
        Scanner scanner = new Scanner(System.in);

        InputStream inputStream = new ConsoleInputStream(scanner);
        CarShopPrinter carShopPrinter = new ANSICarShopPrinter(printStream);

        new ConsoleCarShopController(new CarShop(), inputStream, carShopPrinter);
    }


}
