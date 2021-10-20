package com.ril.ajio.recaptchademo.controller;

import com.ril.ajio.recaptchademo.model.User;
import com.ril.ajio.recaptchademo.service.IUserService;
import com.ril.ajio.recaptchademo.validator.CaptchaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService service;

    @Autowired
    private CaptchaValidator validator;

    @GetMapping("/register")
    public String registerUser(Model model) {
        model.addAttribute("user", new User());
        return "registerUser";
    }

    @PostMapping("/save")
    public String saveUser(
            @ModelAttribute User user,
            Model model,
            @RequestParam("g-recaptcha-response") String captcha
    ) {
        if(validator.isValidCaptcha(captcha)) {
            String userId = service.createUser(user);
            model.addAttribute("message", "User with id : '"+userId+"' Saved Successfully !");
            model.addAttribute("user", new User());
        } else{
            model.addAttribute("message", "Please validate captcha first");
        }

        return "registerUser";
    }

    @GetMapping("/all")
    public String getAllUsers(Model model) {
        List<User> users= service.getAllUsers();
        model.addAttribute("list", users);
        return "listUsers";
    }

}
