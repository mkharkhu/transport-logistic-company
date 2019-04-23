package com.example.demo.service;

import com.example.demo.dto.DistanceDto;

import java.util.List;

public interface DistanceService {

    List<DistanceDto> getDistance(Integer id);

    Long getTotalDiscatnce();
}
