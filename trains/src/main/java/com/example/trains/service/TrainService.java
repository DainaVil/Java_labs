package com.example.trains.service;

import java.util.List;

import com.example.trains.entity.Train;
import com.example.trains.repository.TrainRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TrainService {
    @Autowired

    TrainRepository trainRepository;

    public List<Train> getAllTrains() {
        return trainRepository.findAll();
    }
    public Train getTrain(Integer id) {
        return trainRepository.findById(id).get();
    }

    public void saveTrain(Train train) {
        trainRepository.save(train);
    }

    public void deleteTrain(Integer id) {
         trainRepository.deleteById(id);
    }
}
