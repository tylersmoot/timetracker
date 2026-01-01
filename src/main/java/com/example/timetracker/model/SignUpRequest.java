package com.example.timetracker.model;

import com.example.timetracker.model.enums.Role;
import jakarta.persistence.*;


public class SignUpRequest {

    private String firstName;
    private String lastName;
    private Double yearlyAssignedPtoBalance;
    private Double remainingPtoBalance;
    private String email;
    private String passwordHash;
    private String retypedPassword;

    public SignUpRequest () {};

    public SignUpRequest(String firstName, String lastName, Double yearlyAssignedPtoBalance, Double remainingPtoBalance, String email, String passwordHash, String retypedPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearlyAssignedPtoBalance = yearlyAssignedPtoBalance;
        this.remainingPtoBalance = remainingPtoBalance;
        this.email = email;
        this.passwordHash = passwordHash;
        this.retypedPassword = retypedPassword;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getYearlyAssignedPtoBalance() {
        return yearlyAssignedPtoBalance;
    }

    public void setYearlyAssignedPtoBalance(Double yearlyAssignedPtoBalance) {
        this.yearlyAssignedPtoBalance = yearlyAssignedPtoBalance;
    }

    public Double getRemainingPtoBalance() {
        return remainingPtoBalance;
    }

    public void setRemainingPtoBalance(Double remainingPtoBalance) {
        this.remainingPtoBalance = remainingPtoBalance;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getRetypePassword() {
        return retypedPassword;
    }

    public void setRetypePassword(String retypePassword) {
        this.retypedPassword = retypePassword;
    }


}
