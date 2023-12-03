package by.tms.controller;

import by.tms.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home")
public class HomeController {

    private final static String HOME_PATH = "home_page";
    private final static String USER_HOME_PATH = "user";
    private final static String SHOP_HOME_PATH = "shop";


    @GetMapping("/home_page")
    public String getHome(){
        return HOME_PATH;
    }


    @PostMapping("/user")
    public String getUserHome(@Validated User user){
        return USER_HOME_PATH;
    }


    @GetMapping("/shop")
    public String getShopHomePath(){
        return SHOP_HOME_PATH;
    }



}
