package com.trucks.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.trucks.application.port.PortService;
import com.trucks.domain.Port;

public class PortServiceImpl implements PortService {

    List<Port> ports;

    public PortServiceImpl() {
        this.ports = new ArrayList<>();
        int x = (int) (5 + (Math.random() * (15 - 5)));
        for (int i = 0; i < x; i++) {
            this.ports.add(Port.random());
        }
    }

    @Override
    public List<Port> findAll() {
        return this.ports;
    }

    @Override
    public Optional<Port> find(String id) {
        for (Port port : this.ports) {
            if (port.getId().toString().equals(id)) {
                return Optional.of(port);
            }
        }
        return Optional.empty();
    }
}
