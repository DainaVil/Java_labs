package com.example.trains.service;

import java.util.List;

import com.example.trains.entity.Run;
import com.example.trains.repository.RunRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RunService {
    @Autowired

    RunRepository runRepository;

    public List<Run> getAllRuns() {
        return runRepository.findAll();
    }
    public Run getRun(Integer id) {
        return runRepository.findById(id).get();
    }

    public void saveRun(Run run) {
        runRepository.save(run);
    }

    public void deleteRun(Integer id) {
        runRepository.deleteById(id);
    }
}
