package com.example.timetracker.model;

import com.example.timetracker.model.enums.TimeType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class TimeRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    @Enumerated(EnumType.STRING)
    private TimeType timeType;
    @Column
    private String requestedDate;
    @Column
    private double requestedHours;
    @Column
    private double occurrenceCount;
    @Column
    private String createdAt;


    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt() {
        LocalDate tempTime = LocalDate.now();
        DateTimeFormatter formattedTempTime = DateTimeFormatter.ofPattern("dd-MM-yyy");
        this.createdAt = tempTime.format(formattedTempTime);

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TimeType getTimeType() {
        return timeType;
    }

    public void setTimeType(TimeType timeType) {
        this.timeType = timeType;
    }

    public String getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(String requestedDate) {
        this.requestedDate = requestedDate;
    }

    public double getRequestedHours() {
        return requestedHours;
    }

    public void setRequestedHours(double requestedHours) {
        this.requestedHours = requestedHours;
    }

    public double getOccurrenceCount() {
        return occurrenceCount;
    }

    public void setOccurrenceCount(double occurrenceCount) {
        this.occurrenceCount = occurrenceCount;
    }




}
