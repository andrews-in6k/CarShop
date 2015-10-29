package carShop.servlets;

import carShop.core.entity.Car;
import carShop.core.entity.Manager;
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
public class ManagersServlet extends HttpServlet {

    CarShopService carShopService;

    @Override
    public void init() throws ServletException {
        WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        carShopService = (CarShopService) ctx.getBean("carShop");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("managerId") != null) {
            carShopService.removeManagerById(Integer.parseInt(req.getParameter("managerId")));
        }

        if (req.getParameter("deals") != null) {
            req.setAttribute("dealsManagerId", Integer.parseInt(req.getParameter("deals")));
        }

        req.setAttribute("managers", carShopService.getManagers());

        req.getRequestDispatcher("jsp/managers.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Manager manager = new Manager();

        if (!req.getParameter("textFieldFirstName").equals("") &&
                !req.getParameter("textFieldLastName").equals("")) {
            manager.setFirstName(req.getParameter("textFieldFirstName"));
            manager.setLastName(req.getParameter("textFieldLastName"));

            carShopService.addManager(manager);
        }

        req.setAttribute("managers", carShopService.getManagers());

        req.getRequestDispatcher("jsp/managers.jsp").forward(req, resp);
    }
}
