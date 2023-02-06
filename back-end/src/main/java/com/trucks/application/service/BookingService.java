package com.trucks.application.service;

import java.util.List;
import java.util.Optional;

import com.trucks.application.port.BookingRepository;
import com.trucks.domain.Booking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class BookingService {

    private static final Logger logger = LoggerFactory.getLogger(BookingService.class);
    @Autowired
    private BookingRepository repository;

    public void delete(Booking resource) {
        logger.info("delete=[resource={}]", resource);
        this.repository.delete(resource);
    }

    public List<Booking> findAll() {
        logger.info("findAll");
        return this.repository.findAll();
    }

    public Optional<Booking> findById(String id) {
        logger.info("findById=[id={}]", id);
        return this.repository.findById(id);
    }

    public Optional<Booking> findByName(String name) {
        logger.info("findByName=[name={}]", name);
        return this.repository.findByName(name);
    }

    public void savePort(Booking resource) {
        logger.info("savePort=[resource={}]", resource);
        this.repository.save(resource);
    }

    public Page<Booking> getPage(Pageable pageable) {
        logger.info("getPage=[pageable={}]", pageable);
        return this.repository.findAll(pageable);
    }

    public void updatePort(Booking previousBooking, Booking newBooking) {
        logger.info("updatePort=[previousBooking={},newPort={}]", previousBooking, newBooking);
        // previousBooking.setName(newBooking.getName());
        this.savePort(previousBooking);
    }
}
