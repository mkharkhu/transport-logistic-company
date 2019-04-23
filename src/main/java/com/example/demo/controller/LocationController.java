package com.example.demo.controller;

import com.example.demo.entity.Location;
import com.example.demo.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping(value = "/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping("/{id}")
    public Location getLocationById(@PathVariable("id") Integer id) {
        Location result = locationService.findLocationeById(id);
        return result;
    }

    @PostMapping
    public void addLocation(@RequestBody Location location) {
        locationService.insertLocation(location);
    }

    @PutMapping("/{id}")
    public void updateLocationById(@PathVariable("id") Integer id, @RequestParam("name") String name) {
        Location location1 = locationService.findLocationeById(id);
        if (Objects.nonNull(location1)) {
            location1.setName(name);
            locationService.updateLocation(location1);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteLocationByid(@PathVariable("id") Integer id) {
        locationService.deleteLocationById(id);
    }

}
