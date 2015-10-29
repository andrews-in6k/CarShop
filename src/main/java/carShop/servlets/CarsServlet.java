package carShop.servlets;

import carShop.core.entity.Car;
import carShop.service.CarShopService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by employee on 10/29/15.
 */
public class CarsServlet extends HttpServlet{

    CarShopService carShopService;

    @Override
    public void init() throws ServletException {
        WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        carShopService = (CarShopService) ctx.getBean("carShop");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("carId") != null) {
            carShopService.removeCarById(Integer.parseInt(req.getParameter("carId")));
        }

        req.setAttribute("cars", carShopService.getCars());

        req.getRequestDispatcher("jsp/cars.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Car car = new Car();

        if (!req.getParameter("textFieldBrand").equals("") &&
                !req.getParameter("textFieldName").equals("") &&
                !req.getParameter("textFieldCost").equals("")) {
            car.setBrand(req.getParameter("textFieldBrand"));
            car.setName(req.getParameter("textFieldName"));
            car.setCost(Integer.parseInt(req.getParameter("textFieldCost")));

            carShopService.addCar(car);
        }

        req.setAttribute("cars", carShopService.getCars());

        req.getRequestDispatcher("jsp/cars.jsp").forward(req, resp);
    }
}
