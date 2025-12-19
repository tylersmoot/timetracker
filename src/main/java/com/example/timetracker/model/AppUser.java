package com.example.timetracker.model;

import com.example.timetracker.model.enums.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "app_users")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    double occurrenceBalance;
    @Column
    double ptoBalance;
    @Column
    double yearlyAssignedPtoBalance;

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

    public double getOccurrenceBalance() {
        return occurrenceBalance;
    }

    public void setOccurrenceBalance(double occurrenceBalance) {
        this.occurrenceBalance = occurrenceBalance;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
