package com.example.demo.service.impl;

import com.example.demo.dto.DistanceDto;
import com.example.demo.entity.Location;
import com.example.demo.entity.Route;
import com.example.demo.service.DistanceService;
import com.example.demo.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistanceServiceImpl implements DistanceService {

    @Autowired
    RouteService routeService;

    @Override
    public List<DistanceDto> getDistance(Integer id) {
        Route route = routeService.findRouteById(id);
        List<Location> locationList = route.getLocations();
        List<DistanceDto> distanceList = null;
        DistanceDto distance = null;
        double dist;

        for (int i = 0; i < locationList.size(); i++) {
            dist = Math.sqrt(
                    coordinateСounting(locationList.get(i).getX(), locationList.get(i + 1).getX()) +
                            coordinateСounting(locationList.get(i).getY(), locationList.get(i + 1).getY()));

            distance.setFrom(locationList.get(i).getId());
            distance.setTo(locationList.get(i + 1).getId());
            distance.setDisctance(dist);

            distanceList.add(distance);
        }
        return distanceList;
    }

    @Override
    public Long getTotalDiscatnce() {
        return null;
    }

    public float coordinateСounting(float start, float finish) {
        return (float) Math.pow(finish - start, 2);
    }

}
