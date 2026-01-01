package com.example.timetracker.service;

import com.example.timetracker.model.AppUser;
import com.example.timetracker.model.SignUpRequest;
import com.example.timetracker.model.enums.Role;
import com.example.timetracker.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {


    @Autowired
    private AppUserService appUserService;

public void registerNewUser(SignUpRequest signUpRequest) {
    // unpack sign up request object, set app user
    AppUser appUser = new AppUser();
    appUser.setFirstName(signUpRequest.getFirstName());
    appUser.setLastName(signUpRequest.getLastName());
    appUser.setEmail(signUpRequest.getEmail());
    appUser.setPasswordHash(signUpRequest.getPasswordHash());
    appUser.setOccurrenceBalance(8.0);

    System.out.println("remaining pto balance:" + signUpRequest.getRemainingPtoBalance());
    if(signUpRequest.getRemainingPtoBalance() == null) {
        appUser.setYearlyAssignedPtoBalance(signUpRequest.getYearlyAssignedPtoBalance());
    }
    else {
        appUser.setRemainingPtoBalance(signUpRequest.getRemainingPtoBalance());
    }
    // hash password
    String hashedPassword = BCrypt.hashpw(signUpRequest.getPasswordHash(), BCrypt.gensalt(10));
    appUser.setPasswordHash(hashedPassword);



    // save new app user
    appUserService.saveUser(appUser);

}
}
