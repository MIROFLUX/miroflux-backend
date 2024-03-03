package com.miroflux.backend.authentication.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("authentication")
public class AuthenticationController {

    @GetMapping()
    public String hello(){
        return "Hello MIROFLUX";
    }
}
