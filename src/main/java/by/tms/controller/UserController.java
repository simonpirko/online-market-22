package by.tms.controller;

import by.tms.dto.LoginUserDto;
import by.tms.dto.RegistrationUserDto;
import by.tms.entity.User;
import by.tms.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;



@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/reg")
    public String reg(Model model) {
        model.addAttribute("user",new RegistrationUserDto());
        return "user/reg";
    }

    @PostMapping("/reg")
    public String reg(@Valid @ModelAttribute("user") RegistrationUserDto registrationUserDto,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return " reg";
        }
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new LoginUserDto());
        return "user/login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("user") LoginUserDto loginUserDto,
                        BindingResult bindingResult,
                        HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "user/login";
        }
        session.setAttribute("current user", loginUserDto.getEmailAddress());
        System.out.println(loginUserDto.getEmailAddress());
        return "shop/";

    }

    @GetMapping
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/{id}/userInfo")
    public String getUserInfo(@PathVariable("id")Long id, Model model){
        model.addAttribute("user", userService.findById(id));
        return "user/userInfo";
    }
    @PostMapping("{id}/edit")
    public  String update(@Valid @ModelAttribute("user")LoginUserDto loginUserDto,
                          @PathVariable("id")Long id,
                          BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "user/updatedUser";
        }
        userService.update(id);
        return "shop/";
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id")Long id,HttpSession session){
        userService.removeById(id);
        session.invalidate();
        return "user/";
    }

}

