package com.example.trains.contoller;

import java.util.List;
import java.util.NoSuchElementException;

import com.example.trains.entity.TrainType;
import com.example.trains.service.TrainTypeService;

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
@RequestMapping("/train_types")
public class TrainTypeController {
    @Autowired
    TrainTypeService trainTypeService;

    @GetMapping("")
    public List<TrainType> getAllTrains() {
        return trainTypeService.getAllTypes();
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody TrainType trainType) {
        trainTypeService.saveTrainType(trainType);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public TrainType getTrainById(@PathVariable Integer id) {
        return trainTypeService.getTrainType(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTrain(@PathVariable Integer id) {
        trainTypeService.deleteTrainType(id);
         return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTrain(@RequestBody TrainType trainType, @PathVariable Integer id) {
        try {
            TrainType oldTrainType = trainTypeService.getTrainType(id);
            oldTrainType.updateTrainType(trainType);
            trainTypeService.saveTrainType(oldTrainType);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<TrainType>(HttpStatus.NOT_FOUND);
        }
    }
}
