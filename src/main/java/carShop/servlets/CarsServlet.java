//package carShop.servlets;
//
//import carShop.core.entity.Car;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * Created by employee on 10/29/15.
// */
//public class CarsServlet extends BaseServlet{
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        if (req.getParameter("carId") != null) {
//            Car car = carShopService.getCarById(Integer.parseInt(req.getParameter("carId")));
//            carShopService.removeCar(car);
//        }
//
//        req.setAttribute("cars", carShopService.getCars());
//
//        req.getRequestDispatcher("jsp/cars.jsp").forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        String brand = req.getParameter("textFieldBrand");
//        String name = req.getParameter("textFieldName");
//        String cost = req.getParameter("textFieldCost");
//
//        if (!brand.equals("") && !name.equals("") && !cost.equals("")) {
//            Car car = new Car();
//
//            car.setBrand(brand);
//            car.setName(name);
//            car.setCost(Integer.parseInt(cost));
//
//            carShopService.addCar(car);
//        }
//
//        req.setAttribute("cars", carShopService.getCars());
//
//        req.getRequestDispatcher("jsp/cars.jsp").forward(req, resp);
//    }
//}
