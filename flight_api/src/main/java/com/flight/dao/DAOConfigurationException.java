package com.flight.dao;

public class DAOConfigurationException extends RuntimeException {
    public DAOConfigurationException(String s) {
        super(s);
    }

    public DAOConfigurationException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public DAOConfigurationException(Throwable throwable) {
        super(throwable);
    }
}
