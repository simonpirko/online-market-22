package by.tms.controller;

import by.tms.entity.ShopOrder;
import by.tms.entity.ShoppingCart;
import by.tms.service.ShopOrderService;
import by.tms.service.ShoppingCartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("/user/shop_order")
public class ShopOrderController {
    private final static String CREATE_SHOP_ORDER_PATH = "create";
    private final static String GET_ALL_SHOP_ORDERS_PATH = "all_shop_orders";

    private final static String ATTRIBUTE_SHOP_ORDER = "shop_order";
    private final static String ATTRIBUTE_SHOPPING_CART = "shopping_cart";

    private final ShopOrderService shopOrderService;
    private final ShoppingCartService shoppingCartService;

    public ShopOrderController(ShopOrderService shopOrderService, ShoppingCartService shoppingCartService) {
        this.shopOrderService = shopOrderService;
        this.shoppingCartService = shoppingCartService;
    }


    @GetMapping("/all_shop_orders")
    public String getAllShopOrders(@ModelAttribute(ATTRIBUTE_SHOP_ORDER) ShopOrder shopOrder, Model model) {
        model.addAttribute(ATTRIBUTE_SHOP_ORDER, shopOrderService.findAll());
        return GET_ALL_SHOP_ORDERS_PATH;
    }


    @GetMapping
    public String getShopOrder(@ModelAttribute(ATTRIBUTE_SHOP_ORDER) ShopOrder shopOrder, Model model){
        model.addAttribute(ATTRIBUTE_SHOP_ORDER, shopOrder);
        return ATTRIBUTE_SHOP_ORDER;
    }


    @PostMapping("/cart/{cart_id}/create")          //???????????????????????????????????????????????????????????
    public String getShopOrder(@ModelAttribute(ATTRIBUTE_SHOPPING_CART) ShoppingCart shoppingCart,
                               @ModelAttribute(ATTRIBUTE_SHOP_ORDER) ShopOrder shopOrder, Model model,
                               @PathVariable("cart_id") Long shoppingCartId) {
        Optional<ShoppingCart> currentShoppingCart = shoppingCartService.findById(shoppingCartId);

        if (currentShoppingCart.isPresent()) {
            if (!shoppingCartService.isEmpty(currentShoppingCart.get().getUser().getShoppingCart())) {
                LocalDate orderDate = LocalDate.now();
                shopOrder.setOrderDate(orderDate);
                shopOrderService.save(shopOrder);

                model.addAttribute(ATTRIBUTE_SHOPPING_CART, shoppingCart);
            }
        }
        else{
            model.addAttribute("message", "Shopping cart is empty!");
        }
        return CREATE_SHOP_ORDER_PATH;
    }
}
