package com.example.timetracker.service;

import com.example.timetracker.model.AppUser;
import com.example.timetracker.repository.AppUserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Service
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    public AppUserService(){};


    public AppUser findByEmail(String email){
        return appUserRepository.findByEmail(email);
    }

    public void saveUser(AppUser appUser) {
        appUserRepository.save(appUser);
    }

    public boolean verifyPasswordAuth(HttpSession session, RedirectAttributes redirectAttributes, String userTypedPassword, AppUser appUser) {
        if(BCrypt.checkpw(userTypedPassword, appUser.getPasswordHash())) {
            session.setAttribute("appUser", appUser);
            return true;
        }
        else {
            redirectAttributes.addFlashAttribute("incorrectPasswordError", "Incorrect password, please try again..");
            System.out.println("password incorrect");
        }

        return false;

    }

}

