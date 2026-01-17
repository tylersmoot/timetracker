package com.example.timetracker.service;

import com.example.timetracker.model.AppUser;
import com.example.timetracker.model.TimeRequest;
import com.example.timetracker.model.enums.TimeRequestStatus;
import com.example.timetracker.model.enums.TimeType;
import com.example.timetracker.repository.AppUserRepository;
import com.example.timetracker.repository.TimeRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

   public List<TimeRequest> findByTimeTypeAndAppUser_Id(String type, String loggedInEmail) throws NullPointerException {
        AppUser appUser = appUserRepository.findByEmail(loggedInEmail);
        int appUserId = appUser.getId();

        // return empty list if type value is null or empty
        if(type == null || type.isEmpty()) {
           return List.of();
        }

        TimeType timeType = TimeType.valueOf(type);
        return timeRequestRepository.findByTimeTypeAndAppUser_Id(timeType, appUserId);
   }


    public void cancelTimeRequest(int requestID, String loggedInEmail) {
        TimeRequest timeRequest = timeRequestRepository.findById(requestID);
        double reqHours = timeRequest.getRequestedHours();
        double occCount = timeRequest.getOccurrenceCount();
        AppUser appUser = appUserRepository.findByEmail(loggedInEmail);

        double appUserRemainingBalance = appUser.getRemainingPtoBalance();
        double updatedRemainingBalance = appUserRemainingBalance + reqHours;
        double appUserOccBalance = appUser.getOccurrenceBalance();
        double updatedOccBalance = appUserOccBalance + occCount;

        appUser.setRemainingPtoBalance(updatedRemainingBalance);
        appUser.setOccurrenceBalance(updatedOccBalance);
        appUserRepository.save(appUser);
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
            appUser.setRemainingPtoBalance(appUser.getRemainingPtoBalance() - timeRequest.getRequestedHours());
            appUserRepository.save(appUser);
        }
    }
    public TimeRequest findById(int id) {
        return timeRequestRepository.findById(id);
    }
    public List<TimeRequest> findAllByAppUser_Id(int id) {
        return timeRequestRepository.findAllByAppUser_Id(id);
    }

}
