package com.example.trains.service;

import java.util.List;

import com.example.trains.entity.TrainType;
import com.example.trains.repository.TrainTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class TrainTypeService {
    @Autowired
    TrainTypeRepository trainTypeRepository;

    public List<TrainType> getAllTypes() {
        return trainTypeRepository.findAll();
    }
    public TrainType getTrainType(Integer id) {
        return trainTypeRepository.findById(id).get();
    }

    public void saveTrainType(TrainType trainType) {
        trainTypeRepository.save(trainType);
    }
    public void deleteTrainType(Integer id) {
        trainTypeRepository.deleteById(id);
   }
}
