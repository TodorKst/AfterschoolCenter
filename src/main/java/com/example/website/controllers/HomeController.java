package com.example.website.controllers;

import com.example.website.dtos.EmailDto;
import com.example.website.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/")
public class HomeController {
    private final EmailService emailService;

    public HomeController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping()
    public String getHomeView(Model model) {
        model.addAttribute("emailDto", new EmailDto());
        return "Home";
    }

    @PostMapping()
    public String handleEmailSending(EmailDto emailDto) {
        emailService.sendEmail(emailDto.getName(), emailDto.getEmail(), emailDto.getSubject(), emailDto.getMessage());
        return "redirect:/";
    }
}
