package com.example.spring_mvc_crud.configs;

import com.example.spring_mvc_crud.model.Role;
import com.example.spring_mvc_crud.model.User;
import com.example.spring_mvc_crud.service.RoleService;
import com.example.spring_mvc_crud.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DBInit {
    private final UserService userService;
    private final RoleService roleService;

    public DBInit(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void init() {

        //заранее создаём по 1 роли с каждым возможным именем, присвоение ролей будет только через рольсервис
        for (Role.ALLNAMES roleName : Role.ALLNAMES.values()) {
            Role role = new Role(roleName);
            roleService.saveRole(role);
        }

        //дефолтные юзеры для возможности залогиниться и для теста
        if (userService.findAll().isEmpty()) {
            Role adminRole = roleService.findRoleByName("ROLE_ADMIN");
            Role userRole = roleService.findRoleByName("ROLE_USER");

            User admin = new User();
            admin.setUsername("admin");
            admin.setNewPassword("admin");
            admin.setRoles(Set.of(adminRole, userRole));

            User user = new User();
            user.setUsername("user");
            user.setNewPassword("user");
            user.addRole(userRole);

            userService.save(admin);
            userService.save(user);
        }
    }
}