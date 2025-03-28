package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showUsers(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }

    @GetMapping("/add")
    public String addUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "add";
    }

    @GetMapping("/edit")
    public String editUser(@RequestParam("id") int id, ModelMap model) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") int id) {
        userService.removeUser(id);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }
}
