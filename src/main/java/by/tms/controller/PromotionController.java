package by.tms.controller;

import by.tms.entity.Promotion;
import by.tms.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/promotions")
public class PromotionController {

    @Autowired
    private PromotionService promotionService;

    @GetMapping("/{id}")
    public ModelAndView getPromotionById(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("promotion");

        Optional<Promotion> promotion = promotionService.findPromotionById(id);
        if (promotion.isPresent()){
            modelAndView.addObject("promotion", promotion);
        }
        return modelAndView;
    }

    @GetMapping
    public ModelAndView getAllPromotions() {
        ModelAndView modelAndView = new ModelAndView("promotions");

        List<Promotion> promotions = promotionService.findAllPromotion();
        modelAndView.addObject("promotions", promotions);
        return modelAndView;
    }

    @PostMapping
    public String createPromotion(@ModelAttribute Promotion promotion) {
        promotionService.savePromotion(promotion);
        return "/createPromotions";
    }

    @PostMapping("/{id}")
    public String updatePromotion(@PathVariable Long id, @ModelAttribute Promotion promotion) {
        promotion.setId(id);
        promotionService.updatePromotion(promotion);
        return "/promotions";
    }

    @PostMapping("/{id}/delete")
    public String deletePromotion(@PathVariable Long id) {
        promotionService.removePromotionById(id);
        return "/promotions";
    }
}
