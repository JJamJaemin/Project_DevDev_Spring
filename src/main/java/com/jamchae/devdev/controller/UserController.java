package com.jamchae.devdev.controller;

import ch.qos.logback.core.model.Model;
import com.jamchae.devdev.domain.User;
import com.jamchae.devdev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/new")
    public String newUser() {
        return "testform";
    }

    @PostMapping("/user/new")
    public String create(UserForm userForm) {
        User user = new User();
        user.setUsername(userForm.getName());

        System.out.println("user" + user.getUsername());
        userService.register(user);

        return "redirect:/";
    }

//    @GetMapping("/users")
//    public String listUsers(Model model) {
//        List<User> user = userService.
//    }
}
