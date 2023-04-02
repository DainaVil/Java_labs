package com.example.tests.controller;

import com.example.tests.model.User;
import com.example.tests.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired

    private UserRepository userRepository;

    @GetMapping("/teachers")
    public ResponseEntity<List<User>> getTeachers(){
        return ResponseEntity.ok(this.userRepository.findAllByRoleID(3L));
    }
    @GetMapping("/students")
    public ResponseEntity<List<User>> getStudents(){
        return ResponseEntity.ok(this.userRepository.findAllByRoleID(1L));
    }
}
