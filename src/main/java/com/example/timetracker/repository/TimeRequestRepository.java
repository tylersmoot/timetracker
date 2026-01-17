package com.example.timetracker.repository;

import com.example.timetracker.model.TimeRequest;
import com.example.timetracker.model.enums.TimeRequestStatus;
import com.example.timetracker.model.enums.TimeType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;



public interface TimeRequestRepository extends JpaRepository<TimeRequest, Integer> {

    public TimeRequest findById(int id);
    public List<TimeRequest> findAllByAppUser_Id(int id);
    public List<TimeRequest> findByTimeTypeAndAppUser_Id(TimeType timeType, int appUserId);

}
