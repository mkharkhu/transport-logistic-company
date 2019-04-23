package com.example.demo;

import com.example.demo.entity.Location;
import com.example.demo.entity.Route;
import com.example.demo.repository.LocationRepository;
import com.example.demo.repository.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.h2.tools.Server;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class DemoApplication implements CommandLineRunner {

    private final LocationRepository locationRepository;
    private final RouteRepository routeRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public Server h2TcpServer() throws SQLException {
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092").start();
    }

    @Override
    public void run(String... args) throws Exception {

        Location kyiv = Location.builder().head(true).name("kyiv").x(10).y(20).build();
        Location lviv = Location.builder().head(false).name("lviv").x(30).y(30).build();
        Location kirovohrad = Location.builder().head(true).name("korivohrad").x(100).y(100).build();

        List<Location> locationList = Arrays.asList(kirovohrad, kyiv, lviv);

        List<Route> routeList = Arrays.asList(
                Route.builder().id(10).name("first").head(kyiv).locations(Arrays.asList(kyiv, lviv)).build(),
                Route.builder().id(20).name("second").head(kirovohrad).locations(Arrays.asList(kyiv, lviv, kirovohrad)).build()
        );

        locationRepository.saveAll(locationList);
        routeRepository.saveAll(routeList);
    }
}
