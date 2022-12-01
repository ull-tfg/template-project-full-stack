package com.trucks.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import com.trucks.adapter.rest.json.JsonFields;

public class Booking {

    private UUID id;
    private UUID driver;
    private UUID port;
    private String arrivalTime;
    private String waitingArea;

    public UUID getDriver() {
        return driver;
    }

    public void setDriver(UUID driver) {
        this.driver = driver;
    }

    public UUID getPort() {
        return port;
    }

    public void setPort(UUID port) {
        this.port = port;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getWaitingArea() {
        return waitingArea;
    }

    public void setWaitingArea(String waitingArea) {
        this.waitingArea = waitingArea;
    }

    public Map<String, Object> toJson() {
        Map<String, Object> mappedResource = new HashMap<>();
        mappedResource.put(JsonFields.ID, this.getId());
        mappedResource.put(JsonFields.DRIVER, this.getDriver());
        mappedResource.put(JsonFields.PORT, this.getPort());
        mappedResource.put(JsonFields.ARRIVALTIME, this.getArrivalTime());
        mappedResource.put(JsonFields.WAITING_AREA, this.getWaitingArea());
        return mappedResource;
    }

    @Override
    public String toString() {
        return "Booking=[" +
                "id=" + this.getId() + ", " +
                "port=" + this.getPort() + ", " +
                "driver=" + this.getDriver() + ", " +
                "arrivalTime=" + this.getArrivalTime() + ", " +
                "waitingArea=" + this.getWaitingArea() +
                "]";
    }
}
