package com.trucks.adapter.rest.exception;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

    public static ApiError createBody(int status, String path, String message) {
        ApiError body = new ApiError();
        body.setStatus(status);
        if (status == 400) {
            body.setError(ApiError.MESSAGE_BAD_REQUEST);
        } else if (status == 404) {
            body.setError(ApiError.MESSAGE_NOT_FOUND);
        }
        body.setPath(path);
        body.setTimestamp(new Date());
        body.setMessage(message);
        return body;
    }

    public static ApiError createBody(int status, String path, String message, List<ApiSubError> details) {
        ApiError body = MyExceptionHandler.createBody(status, path, message);
        body.setDetails(details);
        return body;
    }

    public static ApiError createBody(MyException exception, WebRequest request) {
        return MyExceptionHandler.createBody(
                exception.getStatus(),
                ((ServletWebRequest) request).getRequest().getRequestURI(),
                exception.getMessage(),
                exception.getSubErrors());
    }

    // Kaizten exceptions
    @ExceptionHandler(MyException.class)
    protected ResponseEntity<ApiError> handleKaiztenException(MyException exception, WebRequest request) {
        System.out.println("handleKaiztenException");
        return ResponseEntity
                .badRequest()
                .body(MyExceptionHandler.createBody(exception, request));
    }

    @ExceptionHandler(MyBadRequestException.class)
    protected ResponseEntity<ApiError> handleKaiztenBadRequestException(MyBadRequestException exception,
            WebRequest request) {
        System.out.println("KaiztenBadRequestException");
        return ResponseEntity
                .badRequest()
                .body(MyExceptionHandler.createBody(exception, request));
    }

    @ExceptionHandler(MyNotFoundException.class)
    protected ResponseEntity<ApiError> handleKaiztenNotFoundException(MyNotFoundException exception,
            WebRequest request) {
        System.out.println("handleKaiztenNotFoundException");
        return ResponseEntity
                .status(exception.getStatus())
                .body(MyExceptionHandler.createBody(exception, request));
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
            HttpRequestMethodNotSupportedException exception, HttpHeaders headers, HttpStatus status,
            WebRequest request) {
        System.out.println("handleHttpRequestMethodNotSupported");
        String[] supportedMethods = exception.getSupportedMethods();
        if (supportedMethods != null) {
            headers.add("Allow", StringUtils.arrayToDelimitedString(supportedMethods, ", "));
        }
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        ApiError body =  MyExceptionHandler.createBody(
            status.value(),
            ((ServletWebRequest) request).getRequest().getRequestURI(),
            exception.getMessage()); 
        return super.handleExceptionInternal(exception, body, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(
            HttpMediaTypeNotAcceptableException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
        System.out.println("handleHttpMediaTypeNotAcceptable");
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        ApiError body =  MyExceptionHandler.createBody(
            status.value(),
            ((ServletWebRequest) request).getRequest().getRequestURI(),
            exception.getMessage());
        return super.handleExceptionInternal(exception, body, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(
            HttpMediaTypeNotSupportedException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
        System.out.println("handleHttpMediaTypeNotSupported");
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        ApiError body =  MyExceptionHandler.createBody(
            status.value(),
            ((ServletWebRequest) request).getRequest().getRequestURI(),
            ApiError.MESSAGE_UNSUPPORTED_MEDIA_TYPE);
        return super.handleExceptionInternal(exception, body, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            HttpMessageNotReadableException exception,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
        System.out.println("handleHttpMessageNotReadable");
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        ApiError body =  MyExceptionHandler.createBody(
            status.value(),
            ((ServletWebRequest) request).getRequest().getRequestURI(),
            ApiError.MESSAGE_NOT_READABLE);
        return super.handleExceptionInternal(exception, body, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException exception,
            HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        System.out.println("handleNoHandlerFoundException");
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        ApiError body =  MyExceptionHandler.createBody(
            status.value(),
            ((ServletWebRequest) request).getRequest().getRequestURI(),
            ApiError.MESSAGE_ENDPOINT_NOT_VALID);
        System.out.println(headers);
        System.out.println(body);
        return super.handleExceptionInternal(exception, body, headers, status, request);
    }
}
