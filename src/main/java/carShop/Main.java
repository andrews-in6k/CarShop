package carShop;

import carShop.dao.CarDAO;
import carShop.dao.DealDAO;
import carShop.entity.*;
import carShop.entity.Car;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by employee on 10/23/15.
 */
public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "applicationContext.xml" }, true);
        DealDAO carDAO = (DealDAO) context.getBean("dataDaoDeal");

        System.out.println(carDAO.getTableRows().get(0).getSoldCar().getBrand() + carDAO.getTableRows().get(0).getBuyingDate());
    }
}
