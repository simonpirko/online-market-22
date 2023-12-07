package by.tms.controller;

import by.tms.entity.Shop;
import by.tms.service.ShopService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/shop")
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping
    private String createShop(@ModelAttribute("shop") Shop shop){
        shopService.save(shop);
        return "/shop";
    }

    @GetMapping("/{id}")
    public String getShopById(@PathVariable Long id, Model model){
        Optional<Shop> shop = shopService.findById(id);

        if (shop.isPresent()){
            model.addAttribute("shop", shop);
            return "shop";
        } else {
            return "/shop-not-found";
        }
    }

    @GetMapping
    public String getAllShops(Model model) {
        List<Shop> shops = shopService.findAll();

        model.addAttribute("shops", shops);
        return "shop-list";
    }

    @DeleteMapping("/{id}")
    public String deleteShopById(@PathVariable Long id) {
        Optional<Shop> shop = shopService.findById(id);

        if (shop.isPresent()){
            shopService.remove(shop.get());
        }
        return "/shop";
    }

    @PutMapping("/{id}")
    public String updateShop(@PathVariable Long id, @ModelAttribute("updatedShop") Shop updatedShop) {
        Optional<Shop> shop = shopService.findById(id);

        if (shop.isPresent()){
            shopService.update(shop.get());
        }
        return "/shop";
    }

    @GetMapping("/user/{id}")
    public String getShopsByUserId(@PathVariable Long id, Model model) {
        List<Shop> shops = shopService.findByUserId(id);

        model.addAttribute("shops", shops);
        return "shop-list";
    }
}
