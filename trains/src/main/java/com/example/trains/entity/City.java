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
@Table(name = "city")
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @OneToMany(mappedBy = "fromCity")
    @JsonIgnore
    private Set<Run> runsTo;

    @OneToMany(mappedBy = "toCity")
    @JsonIgnore
    private Set<Run> runsFrom;

    private String name;

    public void updateCity(City city) {
        if(city.name != null){
            this.name = city.name;
        }
    }
}
