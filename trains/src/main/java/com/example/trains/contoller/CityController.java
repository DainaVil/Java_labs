package com.example.trains.contoller;

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

import com.example.trains.entity.City;
import com.example.trains.service.CityService;

@RestController
@RequestMapping("/cities")
public class CityController {
    @Autowired

    CityService cityService;

    @GetMapping("")
    public List<City> getAllRuns() {
        return cityService.getAllCities();
    }

    @PostMapping("/")
    public ResponseEntity<?> createUser(@RequestBody City city) {
        cityService.saveCity(city);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public City getCityById(@PathVariable Integer id) {
        return cityService.getCity(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCity(@PathVariable Integer id) {
         cityService.deleteCity(id);
         return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCity(@RequestBody City city, @PathVariable Integer id) {
        try {
            City oldCity = cityService.getCity(id);
            oldCity.updateCity(city);
            cityService.saveCity(oldCity);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<City>(HttpStatus.NOT_FOUND);
        }
    }

}
