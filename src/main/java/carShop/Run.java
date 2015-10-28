package carShop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by employee on 10/20/15.
 */
public class Run {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        CarShopController carShopController = (CarShopController)applicationContext.getBean("carShopController");

        carShopController.startManageCarShop();
    }

}
