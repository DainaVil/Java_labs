package com.control.control.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.control.control.entity.Flight;
import com.control.control.service.FlightService;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired

    FlightService flightService;

    @GetMapping("")
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/{id}")
    public Flight getFlightById(@PathVariable Integer id) {
        return flightService.getFlight(id);
    }

    @PostMapping("/")
    public ResponseEntity<?> createFlight(@RequestBody Flight flight) {
        flightService.saveFlight(flight);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFlight(@RequestBody Flight flight, @PathVariable Integer id) {
        try {
            Flight oldFlight = flightService.getFlight(id);
            oldFlight.updateFlight(flight);
            flightService.saveFlight(oldFlight);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<Flight>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFlight(@PathVariable Integer id) {
        flightService.deleteFlight(id);
         return new ResponseEntity<>(HttpStatus.OK);
    }

    
}
