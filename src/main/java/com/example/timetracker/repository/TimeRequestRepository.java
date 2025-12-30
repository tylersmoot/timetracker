package com.example.timetracker.repository;

import com.example.timetracker.model.TimeRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TimeRequestRepository extends JpaRepository<TimeRequest, Integer> {

    public TimeRequest findById(int id);
}
