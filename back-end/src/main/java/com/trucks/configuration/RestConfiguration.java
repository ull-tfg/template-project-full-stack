package com.trucks.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import es.ull.utils.rest.exception.UllExceptionHandler;

public class RestConfiguration {
    
    @Bean
    public ResponseEntityExceptionHandler responseEntityExceptionHandler() {
        return new UllExceptionHandler();
    }
}
