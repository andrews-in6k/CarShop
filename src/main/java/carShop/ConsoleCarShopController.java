package carShop;

/**
 * Created by anri on 20.10.15.
 */
public class ConsoleCarShopController implements CarShopController {

    CarShop carShop;
    InputStream inputStream;
    CarShopPrinter carShopPrinter;
    Options options;

    public ConsoleCarShopController(CarShop carShop, InputStream inputStream, CarShopPrinter carShopPrinter) {
        this.carShop = carShop;
        this.inputStream = inputStream;
        this.carShopPrinter = carShopPrinter;
    }

    public void startManageCarShop() {

        while (true){
            carShopPrinter.printMainMenu();
            options = inputStream.chooseMainMenuItem();

            switch (options){
                case OUTPUT_AVAILABLE_CARS:
                    carShopPrinter.printAvailableCars(carShop.getCars());
                    break;
            }

        }

    }
}
