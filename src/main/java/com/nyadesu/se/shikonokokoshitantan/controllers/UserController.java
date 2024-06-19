package com.nyadesu.se.shikonokokoshitantan.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nyadesu.se.shikonokokoshitantan.model.UserModel;

@RestController
public class UserController {
    @GetMapping("/user")
    public UserModel getUser(){
        return new UserModel(11, "koshino", "koshino@gmail.com", "12345");
    }
}
