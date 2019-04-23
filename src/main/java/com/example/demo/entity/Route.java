package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Route {

    @Id
    private Integer id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "head_id")
    private Location head;
    @Column(name = "locations")
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "route_location",
            joinColumns = {@JoinColumn(name = "id_route")},
            inverseJoinColumns = {@JoinColumn(name = "id_location")})
    private List<Location> locations;
}
