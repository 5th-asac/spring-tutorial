package com.example.demo.controller;

import com.example.demo.controller.dto.StatisticsDto;
import com.example.demo.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class BackofficeController {
    private final StatisticsService statisticsService;

    @GetMapping("")
    public String main(Model model) {
        StatisticsDto statistics = statisticsService.retrieve(LocalDate.of(2010, 10, 1));
        model.addAttribute("statistics", statistics);
        return "/backoffice/index";
    }

    @GetMapping("/statistics")
    @ResponseBody
    public StatisticsDto statistics() {
        return statisticsService.retrieve(LocalDate.of(2010, 10, 1));
    }
}
