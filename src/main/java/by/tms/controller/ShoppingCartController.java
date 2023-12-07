package by.tms.controller;

import by.tms.entity.ShoppingCart;
import by.tms.service.ShoppingCartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/shopping_cart")
public class ShoppingCartController {
    private final static String ATTRIBUTE_SHOPPING_CART = "shopping_cart";


    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/{id}")
    public String getShoppingCartById(@PathVariable("id") Long id, Model model){

        Optional<ShoppingCart> shoppingCart = shoppingCartService.findById(id);

        if(shoppingCart.isPresent()) {
            model.addAttribute(ATTRIBUTE_SHOPPING_CART, shoppingCart);
        }

        return ATTRIBUTE_SHOPPING_CART;
    }


    @PostMapping("/{id}/clear_all")
    public String clearAll(@PathVariable("id") Long id, Model model){

        ShoppingCart shoppingCart = shoppingCartService.clearAll(id);
        model.addAttribute(ATTRIBUTE_SHOPPING_CART, shoppingCart);

        return ATTRIBUTE_SHOPPING_CART;
    }


//    @PostMapping("/{id}/add_product")
//    public String addProduct(@PathVariable("id") Long id, @ModelAttribute(ATTRIBUTE_SHOPPING_CART) ShoppingCart shoppingCart, Model model){
//
//
//    }

}
