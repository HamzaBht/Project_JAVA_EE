package com.flight.dao.implementations;

import com.flight.api.beans.Flight;
import org.junit.Test;


import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class FlightDAOImplementationTest {
    @Test
    public void TestFindOnExistingID(){
        int id = 1;
        Flight flight = DAOFactory.getInstance().getFlightDAO().Find(id);
        assertNotNull(flight);
        assertEquals(id,flight.getFlightNumber(), "the same flight ID");
    }

    @Test
    public void TestFindOnNotExistingID(){
        Flight flight = DAOFactory.getInstance().getFlightDAO().Find(-1);
        assertNull(flight);
    }

    @Test
    public void TestCreate(){
        Flight flight = DAOFactory.getInstance().getFlightDAO().Find(1);
        flight.setFlightNumber(997590);
        flight.setAvailable(true);
        flight.getArrivalInfo().setDate(LocalDate.now());

        int status = DAOFactory.getInstance().getFlightDAO().Create(flight);
        assertTrue(status >= 1);
    }
    @Test
    public void TestUpdate(){
        Flight flight = DAOFactory.getInstance().getFlightDAO().Find(1);
        flight.setAvailable(false);
        boolean status = DAOFactory.getInstance().getFlightDAO().Update(flight);
        assertTrue(status);
        Flight flight2 = DAOFactory.getInstance().getFlightDAO().Find(1);
        assertFalse(flight2.isAvailable());

        flight.setAvailable(true);
        status = DAOFactory.getInstance().getFlightDAO().Update(flight);
        assertTrue(status);
        flight2 = DAOFactory.getInstance().getFlightDAO().Find(1);
        assertTrue(flight2.isAvailable());
    }
}