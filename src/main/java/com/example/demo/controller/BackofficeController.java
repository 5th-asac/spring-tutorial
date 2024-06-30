package com.example.demo.controller;

import com.example.demo.controller.dto.StatisticsDto;
import com.example.demo.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;

@Slf4j
@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class BackofficeController {
    private final StatisticsService statisticsService;

    @GetMapping("")
    public String main(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info(" - LoggedUser Authentication Info : " + authentication);

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
