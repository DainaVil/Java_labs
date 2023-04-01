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

import com.control.control.entity.Route;
import com.control.control.service.RouteService;

@RestController
@RequestMapping("/routes")
public class RouteController {
    @Autowired

    RouteService routeService;

    @GetMapping("")
    public List<Route> getAllRoutes() {
        return routeService.getAllRoutes();
    }

    @GetMapping("/{id}")
    public Route getRouteById(@PathVariable Integer id) {
        return routeService.getRoute(id);
    }

    @PostMapping("/")
    public ResponseEntity<?> createRoute(@RequestBody Route route) {
        routeService.saveRoute(route);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRoute(@RequestBody Route route, @PathVariable Integer id) {
        try {
            Route oldRoute = routeService.getRoute(id);
            oldRoute.updateRoute(route);
            routeService.saveRoute(oldRoute);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<Route>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRoute(@PathVariable Integer id) {
        routeService.deleteRoute(id);
         return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
