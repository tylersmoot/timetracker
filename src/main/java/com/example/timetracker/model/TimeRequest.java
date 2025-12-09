package com.example.timetracker.model;

import com.example.timetracker.model.enums.TimeType;
import jakarta.persistence.*;

@Entity
public class TimeRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private TimeType timeType;


}
