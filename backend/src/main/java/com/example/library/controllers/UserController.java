package com.example.library.controllers;

import com.example.library.models.User;
import com.example.library.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final String REGISTRATION =  "/registration";
    private final String LOGIN = "/login";
    private final String LOGIN_PAGE = "login";
    private final String REGISTRATION_PAGE = "registration";
    @GetMapping(REGISTRATION)
    private String registration() {
        return REGISTRATION_PAGE;
    }
    @PostMapping(REGISTRATION)
    private User createUser(User user) {
        userService.createUser(user);
        return user;
    }
    @GetMapping(LOGIN)
    private String login(){
        return LOGIN_PAGE;
    }

    @PostMapping(LOGIN)
    private void loginAuth(){}

    @GetMapping("/user/roles")
    public Object getRoles() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @GetMapping("/hello")
    private String hello(){
        return "hello";
    }

    @GetMapping("/admin")
    private String admin() {
        return "admin";
    }

    @GetMapping("/logout")
    private String logout() {
        return "redirect:/";
    }
}
