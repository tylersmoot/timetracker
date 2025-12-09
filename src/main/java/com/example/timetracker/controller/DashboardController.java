package com.example.timetracker.controller;

import com.example.timetracker.model.enums.TimeType;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

@Controller
public class DashboardController {

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
    public String saveTimeOffRequest(HttpSession session, Model model, @RequestParam("timeType")TimeType timeType, @RequestParam("requestDate") String requestDate, @RequestParam("requestHours") double requestHours, @RequestParam("occurrenceCount") double occurrenceCount) {
        String loggedInEmail = (String) session.getAttribute("loggedInEmail");
        model.addAttribute("loggedInEmail", loggedInEmail);
        System.out.println("Logged in user: " + loggedInEmail);
        System.out.println("----New Time Off Request Submission----");
        System.out.println("Time type: " + timeType);
        System.out.println("Request date: " + requestDate);
        System.out.println("Request hours: " + requestHours);
        System.out.println("Occurrence count: " + occurrenceCount);
        return "redirect:/dashboard";
    }
}
