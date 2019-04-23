package com.example.demo.dto;

import java.util.List;

public class PlanDto {

    private List<DistanceDto> distanceList;
    private Double total_distance;

    public PlanDto() {
    }

    public List<DistanceDto> getDistanceList() {
        return distanceList;
    }

    public void setDistanceList(List<DistanceDto> distanceList) {
        this.distanceList = distanceList;
    }

    public Double getTotal_distance() {
        return total_distance;
    }

    public void setTotal_distance(Double total_distance) {
        this.total_distance = total_distance;
    }
}
