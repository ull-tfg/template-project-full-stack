package com.trucks.domain;

import java.util.HashMap;
import java.util.Map;

public class Route {

    private String id;
    private int distance;
    private int time;
    private double fuelConsumption;
    private double departureLatitude;
    private double departureLongitude;
    private double destinationLatitude;
    private double destinationLongitude;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getDepartureLatitude() {
        return departureLatitude;
    }

    public void setDepartureLatitude(double departureLatitude) {
        this.departureLatitude = departureLatitude;
    }

    public double getDepartureLongitude() {
        return departureLongitude;
    }

    public void setDepartureLongitude(double departureLongitude) {
        this.departureLongitude = departureLongitude;
    }

    public double getDestinationLatitude() {
        return destinationLatitude;
    }

    public void setDestinationLatitude(double destinationLatitude) {
        this.destinationLatitude = destinationLatitude;
    }

    public double getDestinationLongitude() {
        return destinationLongitude;
    }

    public void setDestinationLongitude(double destinationLongitude) {
        this.destinationLongitude = destinationLongitude;
    }

    public Map<String, Object> toJson() {
        Map<String, Object> mappedResource = new HashMap<>();
        mappedResource.put("distance", this.getDistance());
        mappedResource.put("time", this.getTime());
        mappedResource.put("fuelConsumption", this.getFuelConsumption());
        mappedResource.put("departureLatitude", this.getDepartureLatitude());
        mappedResource.put("departureLongitude", this.getDepartureLongitude());
        mappedResource.put("destinationLatitude", this.getDestinationLatitude());
        mappedResource.put("destinationLongitude", this.getDestinationLongitude());
        return mappedResource;
    }

    @Override
    public String toString() {
        return "Route [departureLatitude=" + departureLatitude + ", departureLongitude="
                + departureLongitude + ", destinationLatitude=" + destinationLatitude
                + ", destinationLongitude=" + destinationLongitude + ", distance=" + distance
                + ", fuelConsumption=" + fuelConsumption + ", id=" + id + ", time=" + time + "]";
    }
}
