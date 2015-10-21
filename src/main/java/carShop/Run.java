package carShop;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by employee on 10/20/15.
 */
public class Run {

    public static void main(String[] args) {
        PrintStream printStream = new PrintStream(System.out);
        Scanner scanner = new Scanner(System.in);

        InputStream inputStream = new ConsoleInputStream(scanner);
        CarShopPrinter carShopPrinter = new ANSICarShopPrinter(printStream);

        CarShop carShop = new CarShop();
        CarShopController carShopController = new ConsoleCarShopController(carShop, inputStream, carShopPrinter);

        carShopController.startManageCarShop();
    }
}
