package com.control.control.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "routes")
@Data
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // @OneToMany(mappedBy = "routeId")
    // private Set<Flight> flights;
    
    @ManyToOne
    @JoinColumn(name="routesFrom", nullable = false)
    private City cityFrom;

    @ManyToOne
    @JoinColumn(name="routesTo", nullable = false)
    private City cityTo;

    public void updateRoute(Route route){
        if(route.cityFrom != null){
            this.cityFrom = route.cityFrom;
        }
        if(route.cityTo != null){
            this.cityTo = route.cityTo;
        }
    }
}

