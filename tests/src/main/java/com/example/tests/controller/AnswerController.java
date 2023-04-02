package com.example.tests.controller;

import com.example.tests.repository.AnswerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnswerController {
    @Autowired

    private AnswerRepository answerRepository;

    @GetMapping("/answers")
    public ResponseEntity<List<Object[]>> getAnswers(){
        return ResponseEntity.ok(this.answerRepository.findAllByUserID(2L));
    }
}
