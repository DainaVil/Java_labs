package com.example.trains.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "run")
@Data
public class Run {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="fromCity", nullable = false)
    private City fromCity;

    @ManyToOne
    @JoinColumn(name="toCity", nullable = false)
    private City toCity;

    @ManyToOne
    @JoinColumn(name="trainId", nullable = false)
    private Train train;

    private Date departureTime;
    private Date arrivalTime;

    public void updateRun(Run run){
        if (run.fromCity != null) {
            this.fromCity = run.fromCity;
        }
        if (run.toCity != null) {
            this.toCity = run.toCity;
        }
        if (run.departureTime != null) {
            this.departureTime = run.departureTime;
        }
        if (run.arrivalTime != null) {
            this.arrivalTime = run.arrivalTime;
        }
    }
}
