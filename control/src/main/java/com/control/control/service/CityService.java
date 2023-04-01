package com.control.control.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.control.control.entity.City;
import com.control.control.repository.CityRepository;

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
