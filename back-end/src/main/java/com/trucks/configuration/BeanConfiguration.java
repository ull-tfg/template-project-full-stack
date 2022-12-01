package com.trucks.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.trucks.adapter.mongodb.MongoDbBookingRepository;
import com.trucks.adapter.mongodb.MongoDbPortRepository;
import com.trucks.application.port.BookingRepository;
import com.trucks.application.port.PortRepository;
import com.trucks.application.service.BookingService;
import com.trucks.application.service.PortService;

@Configuration
public class BeanConfiguration {

    @Bean
    public BookingRepository bookingRepository() {
        return new MongoDbBookingRepository();
    }

    @Bean
    public PortRepository portRepository() {
        return new MongoDbPortRepository();
    }

    @Bean
    public PortService portService() {
        return new PortService();
    }

    @Bean
    public BookingService bookingService() {
        return new BookingService();
    }
}
