package com.trucks.adapter.mongodb;

import com.trucks.application.port.BookingRepository;
import com.trucks.domain.Booking;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class MongoDbBookingRepository implements BookingRepository {

    private static final Logger logger = LoggerFactory.getLogger(MongoDbBookingRepository.class);
    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public void delete(Booking booking) {
        logger.info(
                "delete=[booking={}]",
                booking);
        this.mongoOperations.remove(booking);
    }

    @Override
    public List<Booking> findAll() {
        logger.info("findAll");
        return this.mongoOperations.findAll(Booking.class);
    }

    @Override
    public Page<Booking> findAll(Pageable pageable) {
        logger.info(
                "findAll=[pageable={}]",
                pageable);
        Query query = new Query().with(pageable);
        List<Booking> list = this.mongoOperations.find(query, Booking.class);
        long count = this.mongoOperations.count(query, Booking.class);
        return new PageImpl<Booking>(list, pageable, count);
    }

    @Override
    public Optional<Booking> findById(String id) {
        logger.info(
                "findById=[id={}]",
                id);
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        return Optional.ofNullable(this.mongoOperations.findOne(query, Booking.class));
    }

    @Override
    public Optional<Booking> findByName(String name) {
        logger.info(
                "findByName=[name={}]",
                name);
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        return Optional.ofNullable(this.mongoOperations.findOne(query, Booking.class));
    }

    @Override
    public void save(Booking booking) {
        logger.info(
                "save=[booking={}]",
                booking);
        this.mongoOperations.save(booking);
    }
}
