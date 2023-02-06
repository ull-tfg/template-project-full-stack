package com.trucks.domain;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.RandomStringUtils;

import com.trucks.adapter.rest.json.JsonFields;

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
        mappedResource.put(JsonFields.ID, this.getId());
        mappedResource.put(JsonFields.NAME, this.getName());
        mappedResource.put(JsonFields.LATITUDE, this.getLatitude());
        mappedResource.put(JsonFields.LONGITUDE, this.getLongitude());
        return mappedResource;
    }

    @Override
    public String toString() {
        return "Port=[" +
                "id=" + this.getId() + ", " +
                "name=" + this.getName() + ", " +
                "latitude=" + this.getLatitude() + ", " +
                "longitue=" + this.getLongitude() +
                "]";
    }
}
