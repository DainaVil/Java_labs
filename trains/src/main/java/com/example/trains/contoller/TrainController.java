package com.example.trains.contoller;

import java.util.List;
import java.util.NoSuchElementException;

import com.example.trains.entity.Train;
import com.example.trains.service.TrainService;

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

@RestController
@RequestMapping("/trains")
public class TrainController {
    @Autowired
    TrainService trainService;

    @GetMapping("")
    public List<Train> getAllTrains() {
        return trainService.getAllTrains();
    }

    @PostMapping("/")
    public ResponseEntity<?> createTrain(@RequestBody Train train) {
        trainService.saveTrain(train);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Train getTrainById(@PathVariable Integer id) {
        return trainService.getTrain(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTrain(@PathVariable Integer id) {
         trainService.deleteTrain(id);
         return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTrain(@RequestBody Train train, @PathVariable Integer id) {
        try {
            Train oldTrain = trainService.getTrain(id);
            oldTrain.updateTrain(train);
            trainService.saveTrain(oldTrain);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<Train>(HttpStatus.NOT_FOUND);
        }
    }
}
