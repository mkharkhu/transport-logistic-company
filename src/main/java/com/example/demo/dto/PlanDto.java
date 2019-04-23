package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.List;

@Data
@Builder
public class PlanDto {

    private List<DistanceDto> distanceList;
    private Long total_distance;
}
