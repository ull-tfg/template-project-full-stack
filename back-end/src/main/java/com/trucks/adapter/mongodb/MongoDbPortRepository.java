package com.trucks.adapter.mongodb;

import com.trucks.application.port.PortRepository;
import com.trucks.domain.Port;

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

public class MongoDbPortRepository implements PortRepository {

    private static final Logger logger = LoggerFactory.getLogger(MongoDbPortRepository.class);
    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public void delete(Port port) {
        logger.info(
                "delete=[port={}]",
                port);
        this.mongoOperations.remove(port);
    }

    @Override
    public List<Port> findAll() {
        logger.info("findAll");
        return this.mongoOperations.findAll(Port.class);
    }

    @Override
    public Page<Port> findAll(Pageable pageable) {
        logger.info(
                "findAll=[pageable={}]",
                pageable);
        Query query = new Query().with(pageable);
        List<Port> list = this.mongoOperations.find(query, Port.class);
        long count = this.mongoOperations.count(query, Port.class);
        return new PageImpl<Port>(list, pageable, count);
    }

    @Override
    public Optional<Port> findById(String id) {
        logger.info(
                "findById=[id={}]",
                id);
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        return Optional.ofNullable(this.mongoOperations.findOne(query, Port.class));
    }

    @Override
    public Optional<Port> findByName(String name) {
        logger.info(
                "findByName=[name={}]",
                name);
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        return Optional.ofNullable(this.mongoOperations.findOne(query, Port.class));
    }

    @Override
    public void save(Port port) {
        logger.info(
                "save=[port={}]",
                port);
        this.mongoOperations.save(port);
    }
}
