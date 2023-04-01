package com.control.control.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "flights")
@Data
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private int routeId;

    private String aviaName;
    private Date Datetime;
    private long Duration;

    public void updateFlight(Flight flight){
        if(flight.routeId != 0){
            this.routeId = flight.routeId;
        }
        if(flight.aviaName != null){
            this.aviaName = flight.aviaName;
        }
        if(flight.Datetime != null){
            this.Datetime = flight.Datetime;
        }
        if(flight.Duration != 0){
            this.Duration = flight.Duration;
        }
    }
}
