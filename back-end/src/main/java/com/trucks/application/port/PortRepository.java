package com.trucks.application.port;

import com.trucks.domain.Port;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface PortRepository {

    void delete(Port port);

    List<Port> findAll();

    Page<Port> findAll(Pageable pageable);

    Optional<Port> findById(@Param("id") String id);

    Optional<Port> findByName(@Param("name") String name);

    void save(Port port);
}
