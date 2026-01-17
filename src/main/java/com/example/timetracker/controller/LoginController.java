package com.example.timetracker.controller;

import com.example.timetracker.service.LoginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(HttpSession session, RedirectAttributes redirectAttributes, @RequestParam("email") String email, @RequestParam("password") String password) {
        session.setAttribute("loggedInEmail", email);
        boolean userVerified = loginService.verifyLoginUser(email, session, redirectAttributes, password);

        if(!userVerified) {
            return "redirect:/login";
        }

        return "redirect:/dashboard";
    }

}
