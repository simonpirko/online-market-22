package by.tms.controller;

import by.tms.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {
    private final static String HOME_PATH = "/home";
    private final static String USER_HOME_PATH = "/home/user";

    private final static String SHOP_HOME_PATH = "/home/shop";


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHome(){
        return HOME_PATH;
    }


    @RequestMapping(value = "/home/user", method = RequestMethod.POST)
    public String getUserHome(@Validated User user){
        return USER_HOME_PATH;
    }


    @RequestMapping(value = "/home/shop", method = RequestMethod.GET)
    public String getShopHomePath(){
        return SHOP_HOME_PATH;
    }
}
