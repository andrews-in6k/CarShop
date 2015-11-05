package carShop.controllers;

import carShop.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by employee on 11/5/15.
 */
public class BaseController {
    @Autowired
    ServiceInterface carShopService;
}
