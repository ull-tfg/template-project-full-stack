package com.trucks.domain.factory;

import org.apache.commons.lang3.RandomStringUtils;

import com.trucks.domain.Port;

public class PortFactory {

    public static Port random() {
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
