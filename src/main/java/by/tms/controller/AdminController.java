package by.tms.controller;

import by.tms.entity.User;
import by.tms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final static String ADMIN_HOME_PATH = "home";
    private final static String ROLE_MANAGEMENT_PATH = "role_management";


    private final static String ATTRIBUTE_USER = "user";
    private final static String ATTRIBUTE_ROLES = "roles";
    private final static String ROLE_ASSIGNMENT = "role_assignment";
    private final static String USER_BY_PHONE_NOT_FOUND = "User with this phone doesn't exist";

    private final UserService userService;
    public AdminController(UserService userService){
        this.userService = userService;
    }



    @GetMapping("/home")
    public String getAdminHome() {
        return ADMIN_HOME_PATH;
    }

    @GetMapping("/role_management")
    public String getRoleManagement(@ModelAttribute(ATTRIBUTE_USER) User user, Model model){

        model.addAttribute(ATTRIBUTE_ROLES, userService.findAll());
        return ROLE_MANAGEMENT_PATH;

    }


    @PostMapping("/role_management")
    public String assignRoleToUser(@ModelAttribute(ATTRIBUTE_USER) User user, BindingResult bindingResult, Model model){
        model.addAttribute(ATTRIBUTE_ROLES, userService.findAll());

        Optional<User> userByPhone = userService.findByPhone(user.getPhoneNumber());

        if(!bindingResult.hasErrors()){
            if(userByPhone.isPresent()){
                userService.assignRoleToUser(userByPhone.get(), user.getRole());       //????????????????????????????????????????
            }
            else {
                bindingResult.addError(new ObjectError(USER_BY_PHONE_NOT_FOUND, "User with this phone number doesn't exist"));
            }
        }
        return ROLE_ASSIGNMENT;
    }
}
