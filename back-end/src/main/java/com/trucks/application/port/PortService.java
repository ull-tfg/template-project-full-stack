package com.trucks.application.port;

import java.util.List;
import java.util.Optional;
import com.trucks.domain.Port;

public interface PortService {
    
    List<Port> findAll();

    Optional<Port> find(String id);
}
