package com.trucks.application.service;

import com.trucks.application.port.PortRepository;
import com.trucks.domain.Port;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class PortService {

    private static final Logger logger = LoggerFactory.getLogger(PortService.class);
    @Autowired
    private PortRepository repository;

    public void delete(Port resource) {
        logger.info("delete=[resource={}]", resource);
        this.repository.delete(resource);
    }

    public List<Port> findAll() {
        logger.info("findAll");
        return this.repository.findAll();
    }

    public Optional<Port> findById(String id) {
        logger.info("findById=[id={}]", id);
        return this.repository.findById(id);
    }

    public Optional<Port> findByName(String name) {
        logger.info("findByName=[name={}]", name);
        return this.repository.findByName(name);
    }

    public void savePort(Port resource) {
        logger.info("savePort=[resource={}]", resource);
        this.repository.save(resource);
    }

    public Page<Port> getPage(Pageable pageable) {
        logger.info("getPage=[pageable={}]", pageable);
        return this.repository.findAll(pageable);
    }

    public void updatePort(Port previousPort, Port newPort) {
        logger.info("updatePort=[previousPort={},newPort={}]", previousPort, newPort);
        previousPort.setName(newPort.getName());
        this.savePort(previousPort);
    }
}
