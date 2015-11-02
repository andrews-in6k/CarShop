package carShop.servlets;

import carShop.core.entity.Car;
import carShop.core.entity.Manager;
import carShop.service.CarShopService;
import carShop.service.newStructure.Service;
import carShop.service.newStructure.ServiceInterface;
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

    ServiceInterface carShopService;

    @Override
    public void init() throws ServletException {
        WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        carShopService = (Service) ctx.getBean("service");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("managerId") != null) {
            Manager manager = carShopService.getManagerById(Integer.parseInt(req.getParameter("managerId")));
            carShopService.removeManager(manager);
        }

        if (req.getParameter("deals") != null) {
            req.setAttribute("dealsManagerId", Integer.parseInt(req.getParameter("deals")));
        }

        req.setAttribute("managers", carShopService.getManagers());

        req.getRequestDispatcher("jsp/managers.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("textFieldFirstName");
        String lastName = req.getParameter("textFieldLastName");

        if (!firstName.equals("") && !lastName.equals("")) {
            Manager manager = new Manager();

            manager.setFirstName(firstName);
            manager.setLastName(lastName);

            carShopService.addManager(manager);
        }

        req.setAttribute("managers", carShopService.getManagers());

        req.getRequestDispatcher("jsp/managers.jsp").forward(req, resp);
    }
}
