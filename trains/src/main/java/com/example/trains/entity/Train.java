package com.example.trains.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "train")
@Data
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private int id;
    
    @Column(name = "name")
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "type")
    private TrainType type;

    @Column(name = "number")
    private String number;

    public void updateTrain(Train train){
        if(train.name != null){
            this.name = train.name;
        }
        if(train.number != null){
            this.number = train.number;
        }
    }
}
