package com.fabrefrederic.business.exception;

/**
 * The sensor is mandatory when the temperature reading is saved
 */
public class SensorIsNotProvidedException extends Exception {

    public SensorIsNotProvidedException() {
        super();
    }

    public SensorIsNotProvidedException(String message) {
        super(message);
    }

    public SensorIsNotProvidedException(Throwable cause) {
        super(cause);
    }

    public SensorIsNotProvidedException(String message, Throwable cause) {
        super(message, cause);
    }
}
