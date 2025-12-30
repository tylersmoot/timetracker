package com.example.timetracker.controller;

import com.example.timetracker.model.AppUser;
import com.example.timetracker.model.TimeRequest;
import com.example.timetracker.model.enums.TimeRequestStatus;
import com.example.timetracker.model.enums.TimeType;
import com.example.timetracker.service.AppUserService;
import com.example.timetracker.service.TimeRequestService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class DashboardController {

    private final TimeRequestService timeRequestService;
    private final AppUserService appUserService;

    public DashboardController(TimeRequestService timeRequestService, AppUserService appUserService) {
        this.timeRequestService = timeRequestService;
        this.appUserService = appUserService;
    }

    @GetMapping("/dashboard")
    public String showDashboardPage(HttpSession session, Model model, RedirectAttributes redirectAttributes) {
        String loggedInEmail = (String) session.getAttribute("loggedInEmail");
        if(loggedInEmail == null) {
            redirectAttributes.addFlashAttribute("sessionError", "Session Expired");
            return "redirect:/login";
        }
        AppUser appUser = appUserService.findByEmail(loggedInEmail);
        model.addAttribute("appUser", appUser);
        List<TimeRequest> allTimeRequests = timeRequestService.getAllTimeRequests();
        model.addAttribute("allTimeRequests", allTimeRequests);
//        model.addAttribute("loggedInEmail", session.getAttribute("loggedInEmail"));
        return "dashboard";
    }

    @PostMapping("/dashboard")
    public String saveTimeOffRequest(HttpSession session, Model model, @RequestParam("timeType")String timeType, @RequestParam("requestDate") String requestDate, @RequestParam("requestHours") double requestHours, @RequestParam("occurrenceCount") double occurrenceCount, @RequestParam("approvalStatus") String approvalStatus) {

        String loggedInEmail = (String) session.getAttribute("loggedInEmail");
        model.addAttribute("loggedInEmail", loggedInEmail);
        AppUser appUser = appUserService.findByEmail(loggedInEmail);
        model.addAttribute("appUser", appUser);
        TimeType type = TimeType.valueOf(timeType);
        TimeRequest timeRequest = new TimeRequest();
        timeRequest.setTimeType(type);
        timeRequest.setRequestedDate(requestDate);
        timeRequest.setRequestedHours(requestHours);
        timeRequest.setOccurrenceCount(occurrenceCount);
        timeRequest.setCreatedAt();
        TimeRequestStatus timeRequestStatus = TimeRequestStatus.valueOf(approvalStatus);
        timeRequest.setTimeRequestStatus(timeRequestStatus);
        timeRequest.setCreatedBy(loggedInEmail);
        timeRequestService.saveTimeRequest(timeRequest);
        System.out.println("Time request saved....");


        // check time type and remove occurrence if valid unscheduled time request
        timeRequestService.removeOccurrenceIfUnscheduledTimeReq(timeRequest, appUser);
        timeRequestService.removePtoIfApprovedTimeReq(timeRequest, appUser);
        List<TimeRequest> allTimeRequests = timeRequestService.getAllTimeRequests();

        model.addAttribute("allTimeRequests", allTimeRequests);
        return "redirect:/dashboard";
    }
}
