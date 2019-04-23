package com.example.demo.service;

import com.example.demo.entity.Location;

public interface LocationService {

    Location findLocationeById(Integer id);

    void insertLocation(Location location);
    void updateLocation(Location location);
    void deleteLocationById(Integer id);
}
