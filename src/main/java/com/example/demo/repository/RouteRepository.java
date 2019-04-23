package com.example.demo.repository;

import com.example.demo.entity.Route;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends PagingAndSortingRepository<Route, Integer> {
}
