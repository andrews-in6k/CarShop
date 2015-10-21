package carShop;

import java.util.Scanner;

/**
 * Created by employee on 10/21/15.
 */
public class ConsoleInputStream implements InputStream{

    private Scanner scanner;

    public ConsoleInputStream(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Options chooseMainMenuItem() {

        switch (scanner.next().charAt(0)) {
            case '1':
                return Options.OUTPUT_AVAILABLE_CARS;
            case '2':
                return Options.OUTPUT_MANAGERS;
            case '3':
                return Options.OUTPUT_DEALS;
            case '4':
                return Options.ADD_CAR;
            case '5':
                return Options.ADD_MANAGER;
            case '6':
                return Options.BUY_CAR;
            case '7':
                return Options.OUTPUT_BEST_MANAGER;
            default:
                return null;
        }

    }
}
