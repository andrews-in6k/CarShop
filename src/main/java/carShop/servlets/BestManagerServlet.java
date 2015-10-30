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
import java.time.LocalDate;

/**
 * Created by employee on 10/30/15.
 */
public class BestManagerServlet extends HttpServlet{
    CarShopService carShopService;

    @Override
    public void init() throws ServletException {
        WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        carShopService = (CarShopService) ctx.getBean("carShop");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("jsp/bestManager.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (!req.getParameter("startDate").equals("") && !req.getParameter("endDate").equals("")) {
            Manager manager;

            manager = carShopService.getBestManager(
                    LocalDate.parse(req.getParameter("startDate")),
                    LocalDate.parse(req.getParameter("endDate"))
            );

            req.setAttribute("bestManager", manager);
        }

        req.getRequestDispatcher("jsp/bestManager.jsp").forward(req, resp);
    }
}
