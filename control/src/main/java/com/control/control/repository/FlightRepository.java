package com.control.control.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.control.control.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer>{
    
}
