package com.example.spring_mvc_crud.controller;

import com.example.spring_mvc_crud.service.UserServiceImpl;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showUserInfo(Model model, Authentication authentication) {
        model.addAttribute("user", userService.findByUsername(authentication.getName()));
        return "user/user";
    }
}
