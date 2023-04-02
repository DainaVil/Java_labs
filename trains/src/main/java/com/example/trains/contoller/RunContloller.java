package com.example.trains.contoller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.trains.entity.Run;
import com.example.trains.service.RunService;

@RestController
@RequestMapping("/runs")
public class RunContloller {
    @Autowired

    RunService runService;

    @GetMapping("")
    public List<Run> getAllRuns() {
        return runService.getAllRuns();
    }

    @PostMapping("/")
    public ResponseEntity<?> createUser(@RequestBody Run run) {
        runService.saveRun(run);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Run getRunById(@PathVariable Integer id) {
        return runService.getRun(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRun(@PathVariable Integer id) {
         runService.deleteRun(id);
         return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Run run, @PathVariable Integer id) {
        try {
            Run oldRun = runService.getRun(id);
            oldRun.updateRun(run);
            runService.saveRun(oldRun);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<Run>(HttpStatus.NOT_FOUND);
        }
    }
}
