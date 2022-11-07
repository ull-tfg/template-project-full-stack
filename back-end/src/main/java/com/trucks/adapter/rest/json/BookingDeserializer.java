package com.trucks.adapter.rest.json;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.trucks.adapter.rest.exception.MyException;
import com.trucks.domain.Booking;
import com.trucks.utils.PortsUtils;
import java.io.IOException;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookingDeserializer extends JsonDeserializer {

    private static final Logger logger = LoggerFactory.getLogger(BookingDeserializer.class);

    @Override
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JacksonException {
        logger.info("Deserializing booking");
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        // driver
        if (!node.has(JsonFields.DRIVER)) {
            throw new MyException().setMessage("Driver not defined");
        }
        final String driver = node.get(JsonFields.DRIVER).textValue();
        try {
            UUID uuid = UUID.fromString(driver);
        } catch (IllegalArgumentException exception) {
            throw new MyException().setMessage("Format of driver not valid");
        }
        // port
        if (!node.has(JsonFields.PORT)) {
            throw new MyException().setMessage("Port not defined");
        }
        final String port = node.get(JsonFields.PORT).textValue();
        try {
            UUID uuid = UUID.fromString(port);
        } catch (IllegalArgumentException exception) {
            throw new MyException().setMessage("Format of port not valid");
        }
        // arrivalTime
        final String arrivalTime = node.get(JsonFields.ARRIVALTIME).textValue();
        if (!PortsUtils.isIsoDate(arrivalTime)) {
            throw new MyException().setMessage("Format of arrival time not valid");
        }
        logger.info("driver=" + driver);
        logger.info("port=" + port);
        logger.info("arrivalTime=" + arrivalTime);
        Booking booking = new Booking();
        booking.setDriver(UUID.fromString(driver));
        booking.setPort(UUID.fromString(port));
        booking.setArrivalTime(arrivalTime);
        return booking;
    }
}
