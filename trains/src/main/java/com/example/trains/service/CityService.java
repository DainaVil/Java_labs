package com.example.trains.service;

import java.util.List;

import com.example.trains.entity.City;
import com.example.trains.repository.CityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CityService {
    @Autowired

    CityRepository cityRepository;

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }
    public City getCity(Integer id) {
        return cityRepository.findById(id).get();
    }

    public void saveCity(City city) {
        cityRepository.save(city);
    }

    public void deleteCity(Integer id) {
        cityRepository.deleteById(id);
    }
}
