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

import com.trucks.application.service.PortService;
import com.trucks.domain.Port;
import com.trucks.utils.PortsUtils;
import es.ull.utils.rest.exception.UllBadRequestException;
import es.ull.utils.rest.exception.UllNotFoundException;

@CrossOrigin(origins = "*")
@RequestMapping(value = RestApiConfiguration.API_VERSION + PortHandler.ENDPOINT,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class PortHandler {

    private static final Logger logger = LoggerFactory.getLogger(PortHandler.class);
    public static final String ENDPOINT = "/ports";
    private PortService portService;

    public PortHandler(PortService service) {
        this.portService = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> get() {
        logger.info("GET '{}'", ENDPOINT);
        return ResponseEntity.ok().body(this.portService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getId(@PathVariable String id,
            @RequestParam(required = false) String arrivalTime) {
        logger.info("GET '{}/{}'", ENDPOINT, id);
        logger.info("Path variables=[id='{}']", id);
        logger.info("Request params=[arrivalTime='{}']", arrivalTime);
        Optional<Port> port = this.portService.findById(id);
        if (port.isPresent()) {
            if (arrivalTime != null) {
                if (PortsUtils.isIsoDate(arrivalTime)) {
                    Map<String, Object> mappedResource = port.get().toJson();
                    mappedResource.put("arrivalTime", arrivalTime);
                    mappedResource.put("turnaroundTime",
                            (int) (300 + (Math.random() * (3600 - 300))));
                    return ResponseEntity.ok().body(mappedResource);
                } else {
                    logger.error("Arrival time not valid");
                    throw new UllBadRequestException().setMessage("Arrival time not valid");
                }
            }
            return ResponseEntity.ok().body(port);
        } else {
            throw new UllNotFoundException();
        }
    }
}
