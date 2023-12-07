package by.tms.controller;

import by.tms.entity.cardpayment.CardPayment;
import by.tms.service.CardPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/card_payment")
@RequiredArgsConstructor
public class CardPaymentController {

    private final CardPaymentService cardService;

    @PostMapping
    private String createCardPayment(@ModelAttribute("cardPayment") CardPayment cardPayment) {
        cardService.save(cardPayment);
        return "/card_payment";
    }

    @GetMapping("/{id}")
    public String getCardById(@PathVariable Long id, Model model) {
        Optional<CardPayment> cardPayment = cardService.findById(id);
        if (cardPayment.isPresent()) {
            model.addAttribute("cardPayment", cardService);
            return "card.html";
        } else {
            return "/card-not-found";
        }
    }

    @GetMapping
    private String getAllCards(Model model) {
        List<CardPayment> cards = cardService.findAll();
        model.addAttribute("cards", cards);
        return "/cards";
    }

    @DeleteMapping("/remove_card/{id}")
    public String deleteCardById(@PathVariable Long id) {
        Optional<CardPayment> cardPayment = cardService.findById(id);
        cardPayment.ifPresent(cardService::remove);
        return "/cards";
    }

    @PutMapping("/{id}")
    public String updateShop(@PathVariable Long id, @ModelAttribute("updatedCard") CardPayment cardPayment) {
        Optional<CardPayment> newCard = cardService.findById(id);
        newCard.ifPresent(cardService::update);
        return "/cards";
    }
}