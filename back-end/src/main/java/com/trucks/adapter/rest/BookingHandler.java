package com.trucks.adapter.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.trucks.adapter.rest.exception.MyBadRequestException;
import com.trucks.application.port.BookingService;
import com.trucks.domain.Booking;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RequestMapping(
    value = RestApiConfiguration.API_VERSION + BookingHandler.ENDPOINT, 
    produces = MediaType.APPLICATION_JSON_VALUE
)
@RestController
public class BookingHandler {

    public static final String ENDPOINT = "/bookings";
    private static final Logger logger = LoggerFactory.getLogger(BookingHandler.class);
    private BookingService bookingService;

    public BookingHandler(BookingService service) {
        logger.info("CONSTRUCTOR " + ENDPOINT + "/");
        this.bookingService = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> get() {
        logger.info("GET " + ENDPOINT + "/");
        return ResponseEntity.ok().body(this.bookingService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getId(@PathVariable String id) {
        logger.info("GET " + ENDPOINT + "/");
        logger.info("\tid: " + id);
        Optional<Booking> port = this.bookingService.find(id);
        if (port.isPresent()) {
            Booking booking = port.get();
            return ResponseEntity.ok().body(booking.toJson());
        } else {
            logger.error("Arrival time not valid");
            throw new MyBadRequestException().setMessage("Arrival time not valid");
        }
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Booking booking) {
        logger.info("POST " + ENDPOINT + "/");
        logger.info("\tbooking: " + booking);
        this.bookingService.save(booking);
        return new ResponseEntity(booking.toJson(), HttpStatus.CREATED);
    }
}
