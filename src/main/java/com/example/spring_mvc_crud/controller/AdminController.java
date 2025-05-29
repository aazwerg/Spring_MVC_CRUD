package com.example.spring_mvc_crud.controller;

import com.example.spring_mvc_crud.model.Role;
import com.example.spring_mvc_crud.model.User;
import com.example.spring_mvc_crud.service.RoleService;
import com.example.spring_mvc_crud.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String getUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "admin/index";
    }

    @GetMapping("/edit")
    public String editUser(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("allRoles", roleService.getAllRoles());
        return "admin/edit";
    }

    @GetMapping("/add")
    public String editUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("allRoles", roleService.getAllRoles());
        return "admin/edit";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user, @RequestParam(value = "newRoles", required = false) List<String> newRoles) {
        User oldUser = userService.findByUsername(user.getUsername());
        if ((oldUser != null) && (oldUser.getId() != user.getId())) {
            throw new RuntimeException("Username " + user.getUsername() + " is already claimed!");
        }
        user.setRoles(new HashSet<>());
        if (newRoles != null) {
            for (String roleName : newRoles) {
                user.addRole(roleService.findRoleByName(roleName));
            }
        }
        userService.save(user);
        return "redirect:/admin";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam int id) {
        userService.delete(id);
        return "redirect:/admin";
    }
}