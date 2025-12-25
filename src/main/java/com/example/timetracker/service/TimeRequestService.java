package com.example.timetracker.service;

import com.example.timetracker.model.AppUser;
import com.example.timetracker.model.TimeRequest;
import com.example.timetracker.model.enums.TimeRequestStatus;
import com.example.timetracker.model.enums.TimeType;
import com.example.timetracker.repository.TimeRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Time;
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

    public void removeOccurrenceIfUnscheduledTimeReq(TimeRequest timeRequest, AppUser appUser) {
        if(timeRequest.getTimeType() == TimeType.UNTIME) {
            appUser.setOccurrenceBalance(appUser.getOccurrenceBalance() - timeRequest.getOccurrenceCount());
        }
    }

    public void removePtoIfApprovedTimeReq(TimeRequest timeRequest, AppUser appUser) {

        if(timeRequest.getTimeRequestStatus() == TimeRequestStatus.APPROVED || timeRequest.getTimeRequestStatus() == TimeRequestStatus.AUTO_APPROVED) {
            appUser.setPtoBalance(appUser.getPtoBalance() - timeRequest.getRequestedHours());
        }
    }
}
