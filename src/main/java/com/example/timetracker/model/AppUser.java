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
    private String passwordHash;
    @Column
    double occurrenceBalance;
    @Column
    Double remainingPtoBalance;
    @Column
    Double yearlyAssignedPtoBalance;

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

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }


}
