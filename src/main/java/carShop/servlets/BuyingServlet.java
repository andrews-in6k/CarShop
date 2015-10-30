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

        if (!req.getParameter("buyingDate").equals("")) {
            if ((req.getParameter("carSelect") != null) && (req.getParameter("managerSelect") != null)) {
                Deal deal = new Deal();

                deal.setSoldCar(carShopService.getCarById(Integer.parseInt(req.getParameter("carSelect"))));
                deal.setManager(carShopService.getManagerById(Integer.parseInt(req.getParameter("managerSelect"))));
                try {
                    deal.setBuyingDate(new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("buyingDate")));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                carShopService.addDeal(deal);

                req.setAttribute("isBuy", "true");
            }
        }

        req.setAttribute("cars", carShopService.getCars());
        req.setAttribute("managers", carShopService.getManagers());

        req.getRequestDispatcher("jsp/buyingCar.jsp").forward(req, resp);
    }
}
