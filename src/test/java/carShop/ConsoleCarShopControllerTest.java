package carShop;

import org.junit.Test;

/**
 * Created by anri on 20.10.15.
 */
public class ConsoleCarShopControllerTest {

    @Test
    public void testCreateConsoleCarShopController() {
        new ConsoleCarShopController(new CarShop());
    }

}
