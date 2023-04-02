package com.example.tests.controller;

import com.example.tests.model.Schedule;
import com.example.tests.repository.ScheduleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScheduleController {
    @Autowired

    private ScheduleRepository scheduleRepository;

    @GetMapping("/tests")
    public ResponseEntity<List<Schedule>> getTests(){
        return ResponseEntity.ok(this.scheduleRepository.findAllByRowIDAndUserID(2L, 2L));
    }
}
