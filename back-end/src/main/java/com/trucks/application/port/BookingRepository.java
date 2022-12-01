package com.trucks.application.port;

import com.trucks.domain.Booking;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface BookingRepository {

    void delete(Booking port);

    List<Booking> findAll();

    Page<Booking> findAll(Pageable pageable);

    Optional<Booking> findById(@Param("id") String id);

    Optional<Booking> findByName(@Param("name") String name);

    void save(Booking port);
}
