package carShop.controllers;

import carShop.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by employee on 11/4/15.
 */
@Controller
@RequestMapping("/deals")
public class DealsController{
    @Autowired
    ServiceInterface carShopService;

    @RequestMapping(method = RequestMethod.GET)
    public String outputDeals(ModelMap model) {
        model.addAttribute("deals", carShopService.getDeals());

        return "deals";
    }
}
