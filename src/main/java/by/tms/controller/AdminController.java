package by.tms.controller;

import by.tms.entity.Role;
import by.tms.entity.Shop;
import by.tms.entity.User;
import by.tms.service.ShopService;
import by.tms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final static String ADMIN_HOME_PATH = "home";
    private final static String ROLE_MANAGEMENT_PATH = "role_management";

    private final static String ATTRIBUTE_USER = "user";
    private final static String ATTRIBUTE_ROLES = "roles";
    private final static String ATTRIBUTE_SHOP = "shop";
    private final static String ROLE_ASSIGNMENT = "role_assignment";
    private final static String USER_BY_PHONE_NOT_FOUND = "User with this phone doesn't exist";
    private final static String USER_BY_ID_NOT_FOUND = "User with this id doesn't exist";
    private final static String SHOP_BY_ID_NOT_FOUND = "Shop with this id doesn't exist";

    private final UserService userService;
    private final ShopService shopService;

    public AdminController(UserService userService, ShopService shopService) {
        this.userService = userService;
        this.shopService = shopService;
    }


    @GetMapping("/home")
    public String getAdminHome() {
        return ADMIN_HOME_PATH;
    }

    @GetMapping("/role_management")
    public String getRoleManagement(@ModelAttribute(ATTRIBUTE_USER) User user, Model model) {

        model.addAttribute(ATTRIBUTE_ROLES, userService.findAll());
        return ROLE_MANAGEMENT_PATH;

    }


    @PostMapping("/role_management")
    @ResponseBody
    public String assignRoleToUser(@RequestParam(name = "role") Role role, @ModelAttribute(ATTRIBUTE_USER) User user, BindingResult bindingResult, Model model) {
        Role[] roleArray = Role.values();
        model.addAttribute(ATTRIBUTE_ROLES, roleArray);

        Optional<User> userByPhone = userService.findByPhone(user.getPhoneNumber());

        if (!bindingResult.hasErrors()) {
            if (userByPhone.isPresent()) {
                userService.assignRoleToUser(userByPhone.get(), role);
            } else {
                bindingResult.addError(new ObjectError(USER_BY_PHONE_NOT_FOUND, "User with this phone number doesn't exist"));
            }
        }
        return ROLE_ASSIGNMENT;
    }


    @DeleteMapping("/delete_user/{id}")
    public void deleteUser(@ModelAttribute(ATTRIBUTE_USER) User user, @PathVariable("id") Long id, BindingResult bindingResult, Model model) {
        Optional<User> userById = userService.findById(id);

        if (userById.isPresent()) {
            model.addAttribute(ATTRIBUTE_USER, userService.findById(id));
            userService.removeById(id);
        } else {
            bindingResult.addError(new ObjectError(USER_BY_ID_NOT_FOUND, "User with this id doesn't exist"));
        }

    }


    @DeleteMapping("/delete_Shop/{id}")
    public void deleteShop(@ModelAttribute(ATTRIBUTE_SHOP) Shop shop, @PathVariable("id") Long id, BindingResult bindingResult, Model model) {
        Optional<Shop> shopById = shopService.findById(id);

        if (shopById.isPresent()) {
            model.addAttribute(ATTRIBUTE_SHOP, userService.findById(id));
            shopService.removeById(id);
        } else {
            bindingResult.addError(new ObjectError(SHOP_BY_ID_NOT_FOUND, "Shop with this id doesn't exist"));
        }

    }

}
