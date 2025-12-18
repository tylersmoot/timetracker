package com.example.timetracker.service;

import com.example.timetracker.model.AppUser;
import com.example.timetracker.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

}

