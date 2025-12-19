package com.example.timetracker.model;

import com.example.timetracker.model.enums.Role;
import jakarta.persistence.*;


public class SignUpRequest {

    private String firstName;
    private String lastName;
    private String email;
    private double yearlyAssignedPtoBalance;
    private double ptoBalance;
    private String password;
    private String retypedPassword;

    public SignUpRequest () {};

    public SignUpRequest(String firstName, String lastName, String email, double yearlyAssignedPtoBalance, double ptoBalance, String password, String retypedPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.yearlyAssignedPtoBalance = yearlyAssignedPtoBalance;
        this.ptoBalance = ptoBalance;
        this.password = password;
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

    public double getYearlyAssignedPtoBalance() {
        return yearlyAssignedPtoBalance;
    }

    public void setYearlyAssignedPtoBalance(double yearlyAssignedPtoBalance) {
        this.yearlyAssignedPtoBalance = yearlyAssignedPtoBalance;
    }

    public double getPtoBalance() {
        return ptoBalance;
    }

    public void setPtoBalance(double ptoBalance) {
        this.ptoBalance = ptoBalance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRetypePassword() {
        return retypedPassword;
    }

    public void setRetypePassword(String retypePassword) {
        this.retypedPassword = retypePassword;
    }


}
