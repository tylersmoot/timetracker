package com.example.timetracker.controller;

import com.example.timetracker.model.SignUpRequest;
import com.example.timetracker.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SignUpController {

    @Autowired
    private SignUpService signUpService;
    private SignUpRequest signUpRequest;

    @GetMapping("/sign-up")
    public String signUp() {
        return "signUp";
    }

    @PostMapping("/sign-up")
    public String signUpForm(@ModelAttribute SignUpRequest signUpRequest) {
        signUpService.registerNewUser(signUpRequest);
        return "login";
    }

}

