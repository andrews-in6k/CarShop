package carShop.controllers;

import carShop.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

/**
 * Created by employee on 11/4/15.
 */
@Controller
@RequestMapping("/buyingcar")
public class BuyingController {
    @Autowired
    ServiceInterface carShopService;

    private boolean isBought = false;

    @RequestMapping(method = RequestMethod.GET)
    public String showVariants(ModelMap model) {
        if (isBought){
            model.addAttribute("isBought", true);
            isBought = false;
        }

        model.addAttribute("cars", carShopService.getCars());
        model.addAttribute("managers", carShopService.getManagers());

        return "buyingCar";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String buyCar(
            @RequestParam("buyingDate") String buyingDate,
            @RequestParam("carSelect") String carSelect,
            @RequestParam("managerSelect") String managerSelect
    ){
        if (!buyingDate.equals("")) {
            if ((carSelect != null) && (managerSelect != null)) {

                carShopService.buyingCar(
                        LocalDate.parse(buyingDate),
                        Integer.parseInt(carSelect),
                        Integer.parseInt(managerSelect)
                );

                isBought = true;
            }
        }

        return "redirect:/buyingcar";
    }
}
