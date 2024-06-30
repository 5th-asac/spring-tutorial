package com.example.demo.service;

import com.example.demo.controller.dto.StatisticsDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class StatisticsService {
    public StatisticsDto retrieve(LocalDate month) {

        return new StatisticsDto(1200, 90000000, "Keyboard");
    }
}
