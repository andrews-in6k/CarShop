//package carShop.servlets;
//
//import carShop.core.entity.Manager;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * Created by employee on 10/29/15.
// */
//public class ManagersServlet extends BaseServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        if (req.getParameter("managerId") != null) {
//            Manager manager = carShopService.getManagerById(Integer.parseInt(req.getParameter("managerId")));
//            carShopService.removeManager(manager);
//        }
//
//        if (req.getParameter("deals") != null) {
//            req.setAttribute("dealsManagerId", Integer.parseInt(req.getParameter("deals")));
//        }
//
//        req.setAttribute("managers", carShopService.getManagers());
//
//        req.getRequestDispatcher("jsp/managers.jsp").forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        String firstName = req.getParameter("textFieldFirstName");
//        String lastName = req.getParameter("textFieldLastName");
//
//        if (!firstName.equals("") && !lastName.equals("")) {
//            Manager manager = new Manager();
//
//            manager.setFirstName(firstName);
//            manager.setLastName(lastName);
//
//            carShopService.addManager(manager);
//        }
//
//        req.setAttribute("managers", carShopService.getManagers());
//
//        req.getRequestDispatcher("jsp/managers.jsp").forward(req, resp);
//    }
//}
