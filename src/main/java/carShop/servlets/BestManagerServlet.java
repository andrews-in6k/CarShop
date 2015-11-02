package carShop.servlets;

import carShop.core.entity.Manager;
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
public class BestManagerServlet extends BaseServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("jsp/bestManager.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");

        if (!startDate.equals("") && !endDate.equals("")) {
            Manager manager = carShopService.getBestManager(LocalDate.parse(startDate), LocalDate.parse(endDate));

            if (manager != null) {
                req.setAttribute("bestManager", manager);
            }
        }

        req.getRequestDispatcher("jsp/bestManager.jsp").forward(req, resp);
    }
}
