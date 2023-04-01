package com.control.control.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.control.control.entity.City;

public interface CityRepository extends JpaRepository<City, Integer>{
    
}
