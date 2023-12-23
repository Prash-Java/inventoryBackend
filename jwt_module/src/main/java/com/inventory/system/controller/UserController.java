package com.inventory.system.controller;

import com.inventory.system.entity.User;
import com.inventory.system.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    Environment environmentProperties;

    @PostConstruct
    public void initRolesAndUsers() {
        if(environmentProperties.getProperty("spring.jpa.hibernate.ddl-auto").trim().equals("create")) {
            userService.initRolesAndUsers();
        }
    }

    @PostMapping({"/registerNewUser"})
    public User registerNewUser(@RequestBody User user) {
        return userService.registerNewUser(user);
    }

    @GetMapping({"/forAdmin"})
    public String forAdmin() {
        return "This URL is accessible only to the admin";
    }

    @GetMapping({"/forUser"})
    public String forUser() {
        return "This URL is accessible only to the user";
    }
}
