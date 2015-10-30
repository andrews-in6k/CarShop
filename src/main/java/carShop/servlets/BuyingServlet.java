package carShop.servlets;

import carShop.core.entity.Deal;
import carShop.core.entity.Manager;
import carShop.service.CarShopService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by employee on 10/30/15.
 */
public class BuyingServlet extends HttpServlet{

    CarShopService carShopService;

    @Override
    public void init() throws ServletException {
        WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        carShopService = (CarShopService) ctx.getBean("carShop");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("cars", carShopService.getCars());
        req.setAttribute("managers", carShopService.getManagers());

        req.getRequestDispatcher("jsp/buyingCar.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String buyingDate = req.getParameter("buyingDate");
        String carSelect = req.getParameter("carSelect");
        String managerSelect = req.getParameter("managerSelect");

        if (carShopService.buyingCar(buyingDate, carSelect, managerSelect)) {
            req.setAttribute("isBuy", "true");
        }

        req.setAttribute("cars", carShopService.getCars());
        req.setAttribute("managers", carShopService.getManagers());

        req.getRequestDispatcher("jsp/buyingCar.jsp").forward(req, resp);
    }
}
