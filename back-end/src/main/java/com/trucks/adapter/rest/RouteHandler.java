package com.trucks.adapter.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.web.bind.annotation.RequestParam;
import com.trucks.adapter.rest.exception.MyBadRequestException;
import com.trucks.application.port.RouteService;
import com.trucks.domain.Route;
import com.trucks.utils.PortsUtils;

@CrossOrigin(origins = "*")
@RequestMapping(
    value = RestApiConfiguration.API_VERSION + RouteHandler.ENDPOINT, 
    produces = MediaType.APPLICATION_JSON_VALUE
)
@RestController
public class RouteHandler {

    public static final String ENDPOINT = "/routes";
    private static final Logger logger = LoggerFactory.getLogger(RouteHandler.class);
    private RouteService bookingService;

    public RouteHandler(RouteService service) {
        logger.info("CONSTRUCTOR " + ENDPOINT + "/");
        this.bookingService = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> get(@RequestParam(required = true) String arrivalTime,
            @RequestParam(required = true) String departureLatitude,
            @RequestParam(required = true) String departureLongitude,
            @RequestParam(required = true) String destinationPort) {
        logger.info("GET " + ENDPOINT + "/");
        logger.info("\tarrivalTime=" + arrivalTime);
        logger.info("\tdepartureLatitude=" + departureLatitude);
        logger.info("\tdepartureLongitude=" + departureLongitude);
        logger.info("\tdestinationPort=" + destinationPort);
        if (arrivalTime == null) {
            logger.error("Arrival time not provided");
            throw new MyBadRequestException().setMessage("Arrival time not provided");
        }
        boolean valid2 = PortsUtils.isIsoDate(arrivalTime);
        if (!valid2) {
            logger.error("Arrival time not valid");
            throw new MyBadRequestException().setMessage("Arrival time not valid");
        }
        //
        Random r = new Random();
        int distance = r.nextInt(300, 3600);
        int time = r.nextInt(300, 3600);
        double fuelConsumption = r.nextDouble(3.0, 20.0);
        //
        Route route = new Route();
        route.setDistance(distance);
        route.setTime(time);
        route.setFuelConsumption(fuelConsumption);
        //route.setDepartureLatitude(departureLatitude);
        //route.setDepartureLongitude(departureLongitude);
        //route.setDestinationLatitude(destinationLatitude);
        //route.setDestinationLongitude(destinationLongitude);
        //
        return ResponseEntity.ok().body(route.toJson());
    }
}
