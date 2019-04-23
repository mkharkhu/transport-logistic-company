package com.example.demo.service;

import com.example.demo.entity.Route;

public interface RouteService {

    Route findRouteById(Integer id);

    void insertRoute(Route route);

    void updateRoute(Route route);

    void deleteRouteById(Integer id);
}
