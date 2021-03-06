package carShop.controllers;

import carShop.core.entity.Manager;
import carShop.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by employee on 11/4/15.
 */
@Controller
@RequestMapping("/managers")
public class ManagersController{
    @Autowired
    ServiceInterface carShopService;

    @RequestMapping(method = RequestMethod.GET)
    public String outputManagers(ModelMap model) {
        model.addAttribute("managers", carShopService.getManagers());

        return "managers";
    }

    @RequestMapping(value = "/{managerId}/deals", method = RequestMethod.GET)
    public String showManagerDeals(@PathVariable int managerId, ModelMap model) {
        model.addAttribute("managers", carShopService.getManagers());
        model.addAttribute("dealsManagerId", managerId);

        return "managers";
    }

    @RequestMapping(value = "/{managerId}", method = RequestMethod.DELETE)
    public String deleteManager(@PathVariable int managerId) {
        carShopService.removeManagerById(managerId);

        return "redirect:/managers";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addManager(Manager manager) {
        carShopService.addManager(manager);

        return "redirect:/managers";
    }
}
