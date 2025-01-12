package com.backend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/user")
    public String sayHi() {
        return "Hi User";
    }

    @GetMapping("/admin")
    public String sayHiAdmin() {
        return "Hi Admin";
    }
}
