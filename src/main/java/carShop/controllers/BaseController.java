package carShop.controllers;

import carShop.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by employee on 11/3/15.
 */
@Controller
public class BaseController {
    ServiceInterface carShopService;

    @Autowired
    BaseController(ServiceInterface carShopService) {
        this.carShopService = carShopService;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("cars", carShopService.getCars());
        return "cars";
    }
}
