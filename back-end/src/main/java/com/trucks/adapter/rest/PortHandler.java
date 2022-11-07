package com.trucks.adapter.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;
import java.util.Optional;
import com.trucks.adapter.rest.exception.MyBadRequestException;
import com.trucks.adapter.rest.exception.MyNotFoundException;
import com.trucks.application.port.PortService;
import com.trucks.domain.Port;
import com.trucks.utils.PortsUtils;

@CrossOrigin(origins = "*")
@RequestMapping(
    value = RestApiConfiguration.API_VERSION + PortHandler.ENDPOINT, 
    produces = MediaType.APPLICATION_JSON_VALUE
)
@RestController
public class PortHandler {

    public static final String ENDPOINT = "/ports";
    private static final Logger logger = LoggerFactory.getLogger(PortHandler.class);
    private PortService portService;

    public PortHandler(PortService service) {
        logger.info("CONSTRUCTOR " + ENDPOINT + "/");
        this.portService = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> get() {
        logger.info("GET " + ENDPOINT + "/");
        return ResponseEntity.ok().body(this.portService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getId(@PathVariable String id,
            @RequestParam(required = false) String arrivalTime
            ) {
        logger.info("GET " + ENDPOINT + "/");
        logger.info("\tid: " + id);
        logger.info("\tarrivalTime=" + arrivalTime);
        Optional<Port> port = this.portService.find(id);
        if (port.isPresent()) {
            if (arrivalTime != null) {
                if (PortsUtils.isIsoDate(arrivalTime)) {
                    Map<String, Object> mappedResource = port.get().toJson();
                    mappedResource.put("arrivalTime", arrivalTime);
                    mappedResource.put("turnaroundTime", (int) (300 + (Math.random() * (3600 - 300))));
                    return ResponseEntity.ok().body(mappedResource);
                } else {
                    logger.error("Arrival time not valid");
                    throw new MyBadRequestException().setMessage("Arrival time not valid");
                }
            }
            return ResponseEntity.ok().body(port);
        } else {
            throw new MyNotFoundException();
        }
    }
}
