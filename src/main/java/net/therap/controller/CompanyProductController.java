package net.therap.controller;

import net.therap.service.CompanyProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User: shakhawat.hossain
 * Date: 6/18/14
 * Time: 3:03 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class CompanyProductController {

    @Autowired
    private CompanyProductService productService;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String showServices(ModelMap modelMap){
        modelMap.addAttribute("message", productService.getProductServiceList().toString()) ;
        return "hello";
    }
}
