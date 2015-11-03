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
@RequestMapping("/cars")
public class BaseController {

    @Autowired
    ServiceInterface carShopService;

    @RequestMapping(method = RequestMethod.GET)
    public String printCars(ModelMap model) {
        model.addAttribute("cars", carShopService.getCars());
        return "cars";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteCar() {

        return "cars";
    }
}
