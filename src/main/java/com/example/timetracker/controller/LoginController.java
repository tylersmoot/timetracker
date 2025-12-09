package com.example.timetracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(RedirectAttributes redirectAttributes, @RequestParam("email") String email, @RequestParam("password") String password) {
        System.out.println("Email: " + email + " " + "Pass hash: " + password);
        redirectAttributes.addFlashAttribute("email", email);
        return "redirect:/dashboard";
    }


}
