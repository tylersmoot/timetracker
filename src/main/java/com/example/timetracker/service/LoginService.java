package com.example.timetracker.service;

import com.example.timetracker.model.AppUser;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
public class LoginService {

    private final AppUserService appUserService;

    public LoginService(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

public boolean verifyLoginUser(String email, HttpSession session, RedirectAttributes redirectAttributes, String password) {
   AppUser appUser = appUserService.findByEmail(email);
   return appUserService.verifyPasswordAuth(session, redirectAttributes, password, appUser);
   }
}
