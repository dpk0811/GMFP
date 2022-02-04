package com.gmfp.controller;

import com.gmfp.model.UserModel;
import com.gmfp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model)
    {
        model.addAttribute("registerRequest", new UserModel());
        return "register_page";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model)
    {
        model.addAttribute("loginRequest", new UserModel());
        return "login_page";
    }

    @GetMapping("/error")
    public String getErrorPage(Model model)
    {
        return "error_page";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UserModel userModel)
    {
        System.out.println("register request:" + userModel);
        UserModel registeredUser = userService.registerUser(userModel.getUsername(), userModel.getPassword());
        return registeredUser == null ? "error_page" : "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserModel userModel, Model model)
    {
        System.out.println("login request:" + userModel);
        UserModel authenticated = userService.authenticate(userModel.getUsername(), userModel.getPassword());
        if(authenticated != null)
        {
            model.addAttribute("userLogin", authenticated.getUsername());
            return "redirect:/prediction";
        }
        else
        {
            return "error_page";
        }
    }
}
