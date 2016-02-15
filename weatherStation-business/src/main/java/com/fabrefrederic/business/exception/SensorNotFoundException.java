package com.fabrefrederic.business.exception;

/**
 * When a sensor is not found
 */
public class SensorNotFoundException extends Exception {

    public SensorNotFoundException() {
        super();
    }

    public SensorNotFoundException(String message) {
        super(message);
    }

    public SensorNotFoundException(Throwable cause) {
        super(cause);
    }

    public SensorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
