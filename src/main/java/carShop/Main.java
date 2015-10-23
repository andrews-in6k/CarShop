package carShop;

import carShop.daoClasses.CarDAO;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by employee on 10/23/15.
 */
public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "applicationContext.xml" }, true);
        CarDAO carDAO = (CarDAO) context.getBean("dataDao");
        System.out.println(carDAO.getCars().get(0));
    }
}
