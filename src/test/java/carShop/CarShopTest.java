package carShop;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by employee on 10/22/15.
 */
public class CarShopTest {

    CarShop carShop;

    @Before
    public void setUp() {
        carShop = new CarShop();
    }

    @Test
    public void testGetBestSalesManager() {
        Car car1 = new Car("Porshe", "911", 95000);
        Car car2 = new Car("Toyota", "Supra", 35000);
        Car car3 = new Car("Mazda", "RX-7", 35000);

        carShop.addCar(new Car("Porshe", "911", 95000));
        carShop.addCar(new Car("Toyota", "Supra", 35000));
        carShop.addCar(new Car("Mazda", "RX-7", 35000));

        SalesManager salesManager1 = new SalesManager("Name1", "Surname1");
        SalesManager salesManager2 = new SalesManager("Name2", "Surname2");

        carShop.addSalesManager(salesManager1);
        carShop.addSalesManager(salesManager2);

        carShop.addDeal(new Deal(LocalDate.of(2015, 2, 1), salesManager1, car1));
        carShop.addDeal(new Deal(LocalDate.now(), salesManager2, car2));
        carShop.addDeal(new Deal(LocalDate.now(), salesManager2, car2));

        LocalDate startDate = LocalDate.of(2015, 1, 1);
        LocalDate endDate = LocalDate.of(2015, 2, 5);

        assertThat(carShop.getBestSalesManager(startDate, endDate).getName(), is("Name1"));
    }
}
