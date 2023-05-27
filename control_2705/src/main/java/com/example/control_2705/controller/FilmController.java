package com.example.control_2705.controller;

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

import com.example.control_2705.entity.Film;
import com.example.control_2705.service.FilmService;

@RestController
@RequestMapping("/films")
public class FilmController {
    @Autowired

    FilmService filmService;

    @GetMapping("")
    public List<Film> getAllFilms() {
        return filmService.getAllFilms();
    }

    @GetMapping("/{id}")
    public Film getFilmById(@PathVariable Integer id) {
        return filmService.getFilm(id);
    }

    @PostMapping("/")
    public ResponseEntity<?> createFilm(@RequestBody Film film) {
        filmService.saveFilm(film);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFilm(@RequestBody Film film, @PathVariable Integer id) {
        try {
            Film oldFilm = filmService.getFilm(id);
            oldFilm.updateFilm(film);
            filmService.saveFilm(oldFilm);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<Film>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFilm(@PathVariable Integer id) {
        filmService.deleteFilm(id);
         return new ResponseEntity<>(HttpStatus.OK);
    }
}
