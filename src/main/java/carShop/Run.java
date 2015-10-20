package carShop;

/**
 * Created by employee on 10/20/15.
 */
public class Run {

    public static void main(String[] args) {
        CarShop carShop = new CarShop();
        CarShopController carShopController = new ConsoleCarShopController(carShop);
    }
}
