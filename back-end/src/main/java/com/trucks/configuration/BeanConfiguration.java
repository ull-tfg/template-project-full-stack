package com.trucks.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.trucks.application.port.BookingService;
import com.trucks.application.port.PortService;
import com.trucks.application.port.RouteService;
import com.trucks.application.service.BookingServiceImpl;
import com.trucks.application.service.PortServiceImpl;
import com.trucks.application.service.RouteServiceImpl;

@Configuration
public class BeanConfiguration {

    @Bean
    public PortService portService() {
        return new PortServiceImpl();
    }

    @Bean
    public RouteService routeService() {
        return new RouteServiceImpl();
    }

    @Bean
    public BookingService bookingService() {
        return new BookingServiceImpl();
    }
}
