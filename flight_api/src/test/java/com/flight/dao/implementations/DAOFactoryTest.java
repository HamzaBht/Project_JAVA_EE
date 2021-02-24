package com.flight.dao.implementations;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DAOFactoryTest {
    @Test
    public void TestInstanceIsUnique(){
        assertEquals(DAOFactory.getInstance(),DAOFactory.getInstance(),"The same instance of DAOFactory");
    }

    @Test
    public void TestInstanceIsNotNull(){
        DAOFactory instance = DAOFactory.getInstance();
        assertNotNull(instance);
    }
}