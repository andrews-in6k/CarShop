package carShop.controllers;

import carShop.core.entity.Car;
import carShop.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by employee on 11/3/15.
 */
@Controller
@RequestMapping("/cars")
public class CarsController extends BaseController{

    @RequestMapping(method = RequestMethod.GET)
    public String outputCars(ModelMap model) {
        model.addAttribute("cars", carShopService.getCars());
        return "cars";
    }

    @RequestMapping(value = "/{carId}/delete", method = RequestMethod.GET)
    public String deleteCar(@PathVariable int carId) {
        carShopService.removeCarById(carId);

        return "redirect:/cars";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addCar(Car car) {
        carShopService.addCar(car);

        return "redirect:/cars";
    }
}
