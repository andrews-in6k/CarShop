package carShop.controllers;

import carShop.core.entity.Manager;
import carShop.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

/**
 * Created by employee on 11/4/15.
 */
@Controller
@RequestMapping("/bestmanager")
public class BestManagerController{
    @Autowired
    ServiceInterface carShopService;

    @RequestMapping(method = RequestMethod.GET)
    public String outputBestManager() {

        return "bestManager";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String getBestManager(
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate,
            ModelMap model
    ) {
        if (!startDate.equals("") && !endDate.equals("")) {
            Manager manager = carShopService.getBestManager(LocalDate.parse(startDate), LocalDate.parse(endDate));

            if (manager != null) {
                model.addAttribute("bestManager", manager);
            }
        }

        return "bestManager";
    }

}
