package carShop.servlets;

import carShop.service.newStructure.Service;
import carShop.service.newStructure.ServiceInterface;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

/**
 * Created by employee on 10/30/15.
 */
public class BuyingServlet extends BaseServlet{
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

        if (!buyingDate.equals("")) {
            if ((carSelect != null) && (managerSelect != null)) {

                carShopService.buyingCar(
                        LocalDate.parse(buyingDate),
                        Integer.parseInt(carSelect),
                        Integer.parseInt(managerSelect)
                );

                req.setAttribute("isBuy", "true");
            }
        }

        req.setAttribute("cars", carShopService.getCars());
        req.setAttribute("managers", carShopService.getManagers());

        req.getRequestDispatcher("jsp/buyingCar.jsp").forward(req, resp);
    }
}
