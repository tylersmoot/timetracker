package com.example.timetracker.service;

import com.example.timetracker.model.TimeRequest;
import com.example.timetracker.repository.TimeRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class TimeRequestService {

    @Autowired
    private TimeRequestRepository timeRequestRepository;



    public void saveTimeRequest(TimeRequest timeRequest) {
        timeRequestRepository.save(timeRequest);
    }
    public List<TimeRequest> getAllTimeRequests() {
        return timeRequestRepository.findAll();
    }
}
