package com.control.control.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "cities")
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;

    @OneToMany(mappedBy = "cityFrom")
    private Set<Route> routesFrom;

    @OneToMany(mappedBy = "cityFrom")
    private Set<Route> routesto;

    public void updateCity(City city){
        if(city.name != null){
            this.name = city.name;
        }
    }


}
