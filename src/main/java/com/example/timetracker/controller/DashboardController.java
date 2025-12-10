package com.example.timetracker.controller;

import com.example.timetracker.model.TimeRequest;
import com.example.timetracker.model.enums.TimeType;
import com.example.timetracker.service.TimeRequestService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Controller
public class DashboardController {


    private final TimeRequestService timeRequestService;

    public DashboardController(TimeRequestService timeRequestService) {
        this.timeRequestService = timeRequestService;
    }

    @GetMapping("/dashboard")
    public String showDashboardPage(HttpSession session, Model model) {
        if(session.getAttribute("loggedInEmail") == null) {
            model.addAttribute("sessionError", "Session Expired");
            return "login";
        }
        model.addAttribute("loggedInEmail", session.getAttribute("loggedInEmail"));
        return "dashboard";
    }

    @PostMapping("/dashboard")
    public String saveTimeOffRequest(HttpSession session, Model model, @RequestParam("timeType")String timeType, @RequestParam("requestDate") String requestDate, @RequestParam("requestHours") double requestHours, @RequestParam("occurrenceCount") double occurrenceCount) {

        String loggedInEmail = (String) session.getAttribute("loggedInEmail");
        model.addAttribute("loggedInEmail", loggedInEmail);
        System.out.println("Logged in user: " + loggedInEmail);
        System.out.println("----New Time Off Request Submission----");
        System.out.println("Time type: " + timeType);
        System.out.println("Request date: " + requestDate);
        System.out.println("Request hours: " + requestHours);
        System.out.println("Occurrence count: " + occurrenceCount);


        TimeType type = TimeType.valueOf(timeType);

        System.out.println("Attempting to save time request to database....");
        TimeRequest timeRequest = new TimeRequest();
        timeRequest.setTimeType(type);
        timeRequest.setRequestedDate(requestDate);
        timeRequest.setRequestedHours(requestHours);
        timeRequest.setOccurrenceCount(occurrenceCount);
        timeRequest.setCreatedAt();
        timeRequestService.saveTimeRequest(timeRequest);
        System.out.println("Time request saved....");

        List<TimeRequest> allTimeRequests = timeRequestService.getAllTimeRequests();
        session.setAttribute("allTimeRequests", allTimeRequests);
        return "redirect:/dashboard";
    }
}
