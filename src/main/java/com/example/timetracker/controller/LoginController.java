package com.example.timetracker.controller;
import com.example.timetracker.model.AppUser;
import com.example.timetracker.service.AppUserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class LoginController {


    private final AppUserService appUserService;

    @Autowired
    public LoginController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(HttpSession session, RedirectAttributes redirectAttributes, @RequestParam("email") String email, @RequestParam("password") String password) {
        session.setAttribute("loggedInEmail", email);
        AppUser appUser = appUserService.findByEmail(email);
        boolean userVerified = appUserService.verifyPasswordAuth(session, redirectAttributes, password, appUser);
        if(!userVerified) {
            return "redirect:/login";
        }

        return "redirect:/dashboard";
    }


}
