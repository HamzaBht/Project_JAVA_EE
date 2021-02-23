package com.flight.api.flight_api;

import com.flight.api.DAOImplementations.*;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("/flights")
public class FlightService {
    private DAOFactory airlineDataService = DAOFactory.getInstance();


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response GetFlights(){
        Response response;

        Collection<Flight> flights = airlineDataService.getFlightDAO().findAll();
        Jsonb jsonb = JsonbBuilder.create();

        response = Response.ok(jsonb.toJson(flights)).build();

        return response;
    }
}
