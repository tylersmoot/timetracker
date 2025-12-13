package com.example.timetracker.model;

import com.example.timetracker.model.enums.Role;
import com.example.timetracker.model.enums.TimeRequestStatus;
import com.example.timetracker.model.enums.TimeType;
import jakarta.persistence.*;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
    @Column
    TimeRequestStatus timeRequestStatus;


    public TimeRequestStatus getTimeRequestStatus() {
        return timeRequestStatus;
    }
    public void setTimeRequestStatus(TimeRequestStatus timeRequestStatus) {
        this.timeRequestStatus = timeRequestStatus;
    }


    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt() {
        LocalDate tempTime = LocalDate.now();
        DateTimeFormatter formattedTempTime = DateTimeFormatter.ofPattern("MM-dd-yyyy");
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
       LocalDate localDate = LocalDate.parse(requestedDate);
       DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
       this.requestedDate = localDate.format(dateTimeFormatter);
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
