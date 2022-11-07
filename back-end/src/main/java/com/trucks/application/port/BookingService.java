package com.trucks.application.port;

import java.util.List;
import java.util.Optional;
import com.trucks.domain.Booking;

public interface BookingService {

    List<Booking> findAll();

    Optional<Booking> find(String id);

    void save(Booking booking);
}
