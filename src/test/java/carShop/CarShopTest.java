//package carShop;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import java.time.LocalDate;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.core.Is.is;
//
///**
// * Created by employee on 10/22/15.
// */
//public class CarShopTest {
//
//    CarShop carShop;
//
//    @Before
//    public void setUp() {
//        carShop = new CarShop();
//    }
//
//    @Test
//    public void testBuyingCar() {
//        Car car1 = new Car("Porshe", "911", 95000);
//        Car car2 = new Car("Toyota", "Supra", 35000);
//
//        SalesManager salesManager = new SalesManager("Ordinary", "Manager");
//
//        LocalDate buyingDate = LocalDate.of(2015, 2, 2);
//
//        carShop.addCar(car1);
//        carShop.addCar(car2);
//
//        carShop.addSalesManager(salesManager);
//
//        carShop.buyingCar(buyingDate, 0, 1);
//
//        assertThat(carShop.getDeals().get(0).getDate(), is(buyingDate));
//        assertThat(carShop.getDeals().get(0).getSalesManager(), is(salesManager));
//        assertThat(carShop.getDeals().get(0).getSoldCar(), is(car2));
//        assertThat(carShop.getCars().contains(car2), is(false));
//    }
//
//    @Test
//    public void testGetBestSalesManager() {
//        Car car1 = new Car("Porshe", "911", 95000);
//        Car car2 = new Car("Toyota", "Supra", 35000);
//        Car car3 = new Car("Mazda", "RX-7", 35000);
//
//        SalesManager salesManager = new SalesManager("Ordinary", "Manager");
//        SalesManager bestSalesManager = new SalesManager("Best", "Manager");
//
//        carShop.addSalesManager(salesManager);
//        carShop.addSalesManager(bestSalesManager);
//
//        carShop.addDeal(new Deal(LocalDate.of(2015, 2, 1), bestSalesManager, car1));
//        carShop.addDeal(new Deal(LocalDate.of(2015, 5, 1), salesManager, car2));
//        carShop.addDeal(new Deal(LocalDate.of(2015, 5, 1), salesManager, car3));
//
//        LocalDate startDate = LocalDate.of(2015, 1, 1);
//        LocalDate endDate = LocalDate.of(2015, 2, 5);
//
//        assertThat(carShop.getBestSalesManager(startDate, endDate), is(bestSalesManager));
//    }
//}
