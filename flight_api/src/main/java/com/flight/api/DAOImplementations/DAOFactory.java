package com.flight.api.DAOImplementations;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.flight.api.DAO.*;
import com.flight.api.flight_api.*;

public class DAOFactory {
    private static final String PROPERTIES_FILE = "config.properties";
    private static final String PROPERTY_URL = "url";
    private static final String PROPERTY_DRIVER = "driver";
    private static final String PROPERTY_USERNAME = "username";
    private static final String PROPERTY_PASSWORD = "password";
    
    private String url;
    private String username;
    private String password;

    private static DAOFactory instance;

    DAOFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public static DAOFactory getInstance() throws DAOConfigurationException {
        if (instance == null) {
            Properties properties = new Properties();
            String url;
            String driver;
            String username;
            String password;

            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream propertiesFile = classLoader.getResourceAsStream(PROPERTIES_FILE);

            if (propertiesFile == null) {
                throw new DAOConfigurationException("Can't find properties file : " + PROPERTIES_FILE);
            }

            try {
                properties.load(propertiesFile);
                url = properties.getProperty(PROPERTY_URL);
                driver = properties.getProperty(PROPERTY_DRIVER);
                username = properties.getProperty(PROPERTY_USERNAME);
                password = properties.getProperty(PROPERTY_PASSWORD);
            } catch (IOException e) {
                throw new DAOConfigurationException("Can't load properties config file : " + PROPERTIES_FILE, e);
            }

            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                throw new DAOConfigurationException("driver doesn't exist in classpath.", e);
            }

            instance = new DAOFactory(url, username, password);
        }
        return instance;
    }

    Connection getConnection() throws SQLException {
        return DriverManager.getConnection( url, username, password );
    }

    public IDAO<Flight> getFlightDAO(){ return new FlightDAOImplementation();}
    public IDAO<Airport> getAirportDAO(){ return new AirportDAOImplementation();}
    public IDAO<Cabine> getCabineDAO(){ return new CabineDAOImplementation();}
    public IDAO<Reservation> getReservationDAO(){ return new ReservationDAOImplementation();}
    public IDAO<City> getCityDAO(){ return new CityDAOImplementation();}
    public IDAO<Pays> getPaysDAO(){ return new PaysDAOImplementation();}

}
