package com.example.trains.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "train_type")
@Data
public class TrainType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;

    @OneToMany(mappedBy = "type")
    @JsonIgnore
    private Set<Train> trains;

    public void updateTrainType(TrainType trainType){
        if(trainType.name != null){
            this.name = trainType.name;
        }
    }
}
