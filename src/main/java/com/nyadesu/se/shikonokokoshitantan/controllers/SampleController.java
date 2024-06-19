package com.nyadesu.se.shikonokokoshitantan.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    @GetMapping("/mom")
    public String hellomom() {
        return "Hello Mom";
    }
}
