package com.flight.api.flight_api;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.core.Application;

import static org.junit.jupiter.api.Assertions.*;

public class FlightServiceTest extends JerseyTest {
    @Override
    protected Application configure(){
        return new ResourceConfig(FlightService.class);
    }

    @Test
    public void TestIfReplyNotNull(){
        final String response = target("flights").request().get(String.class);
        Assert.assertNotNull(response);
        System.out.println(response);
    }
}