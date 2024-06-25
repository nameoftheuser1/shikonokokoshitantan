package com.nyadesu.se.shikonokokoshitantan.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nyadesu.se.shikonokokoshitantan.model.UserModel;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class UserController {
    @GetMapping("/user")
    public UserModel getUser() {
        return new UserModel(11, "koshino", "koshino@gmail.com", "12345");
    }

    public String getMethodName(@RequestParam String param) {
        return new String();
    }

    @GetMapping("/users")
    public List<UserModel> getUsers() {
        List<UserModel> users = new ArrayList<>();
        users.add(new UserModel(1, "mario", "mario@gmail.com", "1234"));
        users.add(new UserModel(2, "leo", "leo@gmail.com", "1234"));
        users.add(new UserModel(3, "jon", "jon@gmail.com", "1234"));
        users.add(new UserModel(4, "mike", "mike@gmail.com", "1234"));

        return users;
    }

    @GetMapping("/user/{name}")
    public UserModel getUserFromName(@PathVariable("name") String name) {
        return new UserModel(1, "mario", "mario@gmail.com", "1234");
    }
}
