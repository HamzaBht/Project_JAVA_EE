package com.flight.api.flight_api;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("/flights")
public class FlightService {
    private Airline airlineDataService = Airline.getInstance();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response GetFlights(){
        Response response;

        Collection<Flight> flights = airlineDataService.GetAllFlights();
        Jsonb jsonb = JsonbBuilder.create();

        response = Response.ok(jsonb.toJson(flights)).build();

        return response;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response AddFlight(String flightJson){
        Response response;

        Jsonb jsonb = JsonbBuilder.create();
        Flight flight = jsonb.fromJson(flightJson, Flight.class);

        try{
            airlineDataService.AddFlight(flight);
            response = Response.ok(flight.toString()).build();
            return response;
        }
        catch (AircraftNotExistingException e){
            response = Response.serverError().entity(
                    "Aircraft doesn't exist\nID : "
                            +flight.getAircraft().getID()+"\nCapacity : "
                            +flight.getAircraft().getTotalCapacity()
            ).build();
            return response;
        }
    }
}
