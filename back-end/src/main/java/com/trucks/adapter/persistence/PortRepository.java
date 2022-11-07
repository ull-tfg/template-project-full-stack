package com.trucks.adapter.persistence;

import com.trucks.domain.Port;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.query.Param;

public interface PortRepository {

    void delete(Port sampling);

    List<Port> findAll();

    Page<Port> findAll(Query query, Pageable pageable);

    Optional<Port> findById(@Param("id") String id);
}
