package com.example.timetracker.service;

import com.example.timetracker.model.AppUser;
import com.example.timetracker.model.TimeRequest;
import com.example.timetracker.model.enums.TimeRequestStatus;
import com.example.timetracker.model.enums.TimeType;
import com.example.timetracker.repository.AppUserRepository;
import com.example.timetracker.repository.TimeRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Time;
import java.util.List;


@Service
public class TimeRequestService {

    @Autowired
    private TimeRequestRepository timeRequestRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    public void saveTimeRequest(TimeRequest timeRequest) {
        timeRequestRepository.save(timeRequest);
    }
    public List<TimeRequest> getAllTimeRequests() {
        return timeRequestRepository.findAll();
    }
    public void deleteTimeRequest(TimeRequest timeRequest) {
        timeRequestRepository.delete(timeRequest);

    }
    public void updateTimeRequestStatusAndPto(TimeRequestStatus status, int requestID, String loggedInEmail) {
        TimeRequest timeRequest = timeRequestRepository.findById(requestID);
        timeRequest.setTimeRequestStatus(status);
        AppUser appUser = appUserRepository.findByEmail(loggedInEmail);

        removePtoIfApprovedTimeReq(timeRequest, appUser);
        timeRequestRepository.save(timeRequest);
        appUserRepository.save(appUser);

    }


    public void removeOccurrenceIfUnscheduledTimeReq(TimeRequest timeRequest, AppUser appUser) {
        if(timeRequest.getTimeType() == TimeType.UNTIME) {
            appUser.setOccurrenceBalance(appUser.getOccurrenceBalance() - timeRequest.getOccurrenceCount());
            appUserRepository.save(appUser);
        }
    }

    public void removePtoIfApprovedTimeReq(TimeRequest timeRequest, AppUser appUser) {

        if(timeRequest.getTimeRequestStatus() == TimeRequestStatus.APPROVED || timeRequest.getTimeRequestStatus() == TimeRequestStatus.AUTO_APPROVED) {
            appUser.setPtoBalance(appUser.getPtoBalance() - timeRequest.getRequestedHours());
            appUserRepository.save(appUser);
        }
    }
    public TimeRequest findById(int id) {
        return timeRequestRepository.findById(id);
    }
}
