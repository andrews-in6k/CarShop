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

/**
 * Created by employee on 11/4/15.
 */
@Controller
@RequestMapping("/managers")
public class ManagersController {

    @Autowired
    ServiceInterface carShopService;

    @RequestMapping(method = RequestMethod.GET)
    public String outputManagers(ModelMap model) {
        model.addAttribute("managers", carShopService.getManagers());

        return "managers";
    }

    @RequestMapping(value = "/deals/{managerId}", method = RequestMethod.GET)
    public String showManagerDeals(@PathVariable int managerId, ModelMap model) {
        model.addAttribute("managers", carShopService.getManagers());
        model.addAttribute("dealsManagerId", managerId);

        return "managers";
    }

    @RequestMapping(value = "/{managerId}", method = RequestMethod.GET)
    public String deleteManager(@PathVariable int managerId) {
        carShopService.removeManagerById(managerId);

        return "redirect:/managers";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addManager(
            @RequestParam("textFieldFirstName") String firstName,
            @RequestParam("textFieldLastName") String lastName
    ) {
        if (!firstName.equals("") && !lastName.equals("")) {
            Manager manager = new Manager();

            manager.setFirstName(firstName);
            manager.setLastName(lastName);

            carShopService.addManager(manager);
        }

        return "redirect:/managers";
    }
}
