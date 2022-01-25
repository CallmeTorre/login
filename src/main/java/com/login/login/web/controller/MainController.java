package com.login.login.web.controller;

import java.util.Map;

import com.login.login.domain.LoginUserDetails;
import com.login.login.domain.User;
import com.login.login.domain.repository.UserRepository;
import com.login.login.domain.service.LoginUserDetailsService;

import com.login.login.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = {
            MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public void addUser(@RequestParam Map<String, String> body) {
        User user = new User();
        user.setUserName(body.get("username"));
        user.setPassword(passwordEncoder.encode(body.get("password")));
        LoginUserDetails loginUserDetails = new LoginUserDetails(user);
        userService.save(user);
    }
}
