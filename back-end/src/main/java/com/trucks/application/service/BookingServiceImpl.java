package com.trucks.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.trucks.application.port.BookingService;
import com.trucks.domain.Booking;
import org.apache.commons.lang3.RandomStringUtils;

public class BookingServiceImpl implements BookingService {

    private List<Booking> bookings;

    public BookingServiceImpl() {
        this.bookings = new ArrayList<>();
    }

    @Override
    public List<Booking> findAll() {
        return this.bookings;
    }

    @Override
    public void save(Booking booking) {
        booking.setId(UUID.randomUUID());
        booking.setWaitingArea(RandomStringUtils.randomAlphabetic(4));
        this.bookings.add(booking);
    }

    @Override
    public Optional<Booking> find(String id) {
        for (Booking booking : this.bookings) {
            if (booking.getId().toString().equals(id)) {
                return Optional.of(booking);
            }
        }
        return Optional.empty();
    }
}
