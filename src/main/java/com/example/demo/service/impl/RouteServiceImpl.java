package com.example.demo.service.impl;

import com.example.demo.entity.Route;
import com.example.demo.repository.RouteRepository;
import com.example.demo.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class RouteServiceImpl implements RouteService {

    @Autowired
    RouteRepository routeRepository;

    @Override
    public Route findRouteById(Integer id) {
        return Optional.ofNullable(routeRepository.findById(id)).get().orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void insertRoute(Route route) {
        routeRepository.save(route);

    }

    @Override
    public void updateRoute(Route route) {
        routeRepository.save(route);

    }

    @Override
    public void deleteRouteById(Integer id) {
        routeRepository.deleteById(id);
    }
}
