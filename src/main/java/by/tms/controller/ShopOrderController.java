package by.tms.controller;

import by.tms.service.ShopOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/shop_order")
public class ShopOrderController {
    private final static String CREATE_SHOP_ORDER_PATH = "create";

    private final ShopOrderService shopOrderService;

    public ShopOrderController(ShopOrderService shopOrderService) {
        this.shopOrderService = shopOrderService;
    }


    @GetMapping("/create")
    public String createShopOrder(){
return CREATE_SHOP_ORDER_PATH;
    }
}
