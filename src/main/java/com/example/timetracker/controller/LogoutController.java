package com.example.timetracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {
    @GetMapping("/logout")
    public String logout(Model model) {
        model.addAttribute("logoutConfirmationMessage", "Successfully logged out!");
        return "login";
    }

}
