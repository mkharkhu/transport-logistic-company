package com.example.demo.service.impl;

import com.example.demo.entity.Location;
import com.example.demo.repository.LocationRepository;
import com.example.demo.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class LocationServiceImpl implements LocationService {

    @Autowired
    LocationRepository locationRepository;

    @Override
    public Location findLocationeById(Integer id) {
        return Optional.ofNullable(locationRepository.findById(id)).get().orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void insertLocation(Location location) {
        locationRepository.save(location);
    }

    @Override
    public void updateLocation(Location location) {
        locationRepository.save(location);
    }

    @Override
    public void deleteLocationById(Integer id) {
        locationRepository.deleteById(id);
    }
}
