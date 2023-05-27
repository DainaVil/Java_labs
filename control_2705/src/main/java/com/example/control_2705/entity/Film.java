package com.example.control_2705.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "films")
@Data
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String genre;
    private int duration;
    private int film_year;

    public void updateFilm(Film film){
        if(film.name != null){
            this.name = film.name;
        }
        if(film.genre != null){
            this.genre = film.genre;
        }
        if(film.duration != 0){
            this.duration = film.duration;
        }
        if(film.film_year != 0){
            this.film_year = film.film_year;
        }
    }
}
