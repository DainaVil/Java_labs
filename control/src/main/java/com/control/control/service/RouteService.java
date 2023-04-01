package com.control.control.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.control.control.entity.Route;
import com.control.control.repository.RouteRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class RouteService {
    @Autowired

    RouteRepository routeRepository;

    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }
    public Route getRoute(Integer id) {
        return routeRepository.findById(id).get();
    }

    public void saveRoute(Route route) {
        routeRepository.save(route);
    }

    public void deleteRoute(Integer id) {
        routeRepository.deleteById(id);
    }
}
