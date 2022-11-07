package com.trucks.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;

public class Port {

    private String id;
    private String name;
    private double latitude;
    private double longitude;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Map<String, Object> toJson() {
        Map<String, Object> mappedResource = new HashMap<>();
        mappedResource.put("id", this.getId());
        mappedResource.put("name", this.getName());
        mappedResource.put("latitude", this.getLatitude());
        mappedResource.put("longitude", this.getLongitude());
        return mappedResource;
    }

    public static Port random() {
        Random r = new Random();
        Port port = new Port();
        port.setId(RandomStringUtils.randomAlphabetic(10));
        port.setName(RandomStringUtils.randomAlphabetic(10));
        double latitude = Math.random() * (90 - (-90));
        double longitude = Math.random() * (180 - (-180));
        port.setLatitude(latitude);
        port.setLongitude(longitude);
        return port;
    }
}
