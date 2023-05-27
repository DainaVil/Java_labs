package com.example.control_2705.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.control_2705.entity.Film;

public interface FilmRepository extends JpaRepository<Film, Integer>{
    
}
