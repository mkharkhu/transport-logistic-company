package com.example.demo.controller;

import com.example.demo.dto.PlanDto;
import com.example.demo.entity.Route;
import com.example.demo.service.DistanceService;
import com.example.demo.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping(value = "/routes")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @Autowired
    private DistanceService distanceService;

    @GetMapping("/{id}")
    public Route getRouteById(@PathVariable("id") Integer id) {
        return routeService.findRouteById(id);
    }

    @PostMapping
    public void addRoute(@RequestBody Route route) {
        routeService.insertRoute(route);
    }

    @PutMapping("/{id}")
    public void updateRouteById(@PathVariable("id") Integer id, @RequestParam("name") String name) {
        Route route = routeService.findRouteById(id);
        if (Objects.nonNull(route)) {
            route.setName(name);
            routeService.updateRoute(route);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteRouteByid(@PathVariable("id") Integer id) {
        routeService.deleteRouteById(id);
    }

    @GetMapping("/{id}/plan")
    public PlanDto getRoutePlan(@PathVariable("id") Integer id) {
        return distanceService.getDistance(id);
    }
}
