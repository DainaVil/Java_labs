package com.control.control.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.control.control.entity.Flight;
import com.control.control.repository.FlightRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FlightService {
    @Autowired

    FlightRepository flightRepository;

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }
    public Flight getFlight(Integer id) {
        return flightRepository.findById(id).get();
    }

    public void saveFlight(Flight flight) {
        flightRepository.save(flight);
    }

    public void deleteFlight(Integer id) {
        flightRepository.deleteById(id);
    }
}
