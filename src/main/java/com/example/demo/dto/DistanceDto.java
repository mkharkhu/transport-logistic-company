package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DistanceDto {

    private Integer from;
    private Integer to;
    private double disctance;

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public double getDisctance() {
        return disctance;
    }

    public void setDisctance(double disctance) {
        this.disctance = disctance;
    }
}
