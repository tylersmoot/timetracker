package com.example.timetracker.controller;

import com.example.timetracker.model.AppUser;
import com.example.timetracker.model.TimeRequest;
import com.example.timetracker.model.enums.TimeRequestStatus;
import com.example.timetracker.service.AppUserService;
import com.example.timetracker.service.TimeRequestService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TimeRequestDetailsController {

    @Autowired
    TimeRequestService timeRequestService;
    @Autowired
    AppUserService appUserService;

    @GetMapping("/request/{id}")
    public String showTimeRequestDetailsPage(HttpSession session, Model model, @PathVariable("id") int requestId) {
        String loggedInEmail = (String) session.getAttribute("loggedInEmail");
        TimeRequest timeRequest = timeRequestService.findById(requestId);
        AppUser appUser = appUserService.findByEmail(loggedInEmail);
        model.addAttribute("appUser", appUser);
        model.addAttribute("timeRequest", timeRequest);
        return "timeRequestDetails";
    }

    @PostMapping("/request/update")
    public String updateTimeRequestStatus(HttpSession session, @RequestParam("id") int requestId, @RequestParam("reqStatusChangeInput") TimeRequestStatus statusChange) {
        String loggedInEmail = (String) session.getAttribute("loggedInEmail");

        timeRequestService.updateTimeRequestStatusAndPto(statusChange, requestId, loggedInEmail);
        return "redirect:/request/" + requestId;
    }


}
