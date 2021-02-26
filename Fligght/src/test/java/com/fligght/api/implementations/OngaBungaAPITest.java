package com.fligght.api.implementations;

import com.fligght.beans.Flight;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class OngaBungaAPITest {
    @Test
    void TestIfFlightCreatedFromJsonSuccessfully(){
        String jsonFlightTest = "{\n" +
                "    \"arrivalInfo\": {\n" +
                "      \"airport\": {\n" +
                "        \"city\": {\n" +
                "          \"name\": \"Paris\",\n" +
                "          \"pays\": {\n" +
                "            \"name\": \"France\"\n" +
                "          }\n" +
                "        },\n" +
                "        \"name\": \" Paris-Charles de Gaulle\"\n" +
                "      },\n" +
                "      \"date\": \"2021-02-28\",\n" +
                "      \"hour\": \"11:45:00\"\n" +
                "    },\n" +
                "    \"available\": false,\n" +
                "    \"cabine\": {\n" +
                "      \"availablePlaces\": 0,\n" +
                "      \"capacity\": 343,\n" +
                "      \"type\": \"Économie\"\n" +
                "    },\n" +
                "    \"departureInfo\": {\n" +
                "      \"airport\": {\n" +
                "        \"city\": {\n" +
                "          \"name\": \"Salé\",\n" +
                "          \"pays\": {\n" +
                "            \"name\": \"Maroc\"\n" +
                "          }\n" +
                "        },\n" +
                "        \"name\": \" Aéroport Rabat-Salé\"\n" +
                "      },\n" +
                "      \"date\": \"2021-02-28\",\n" +
                "      \"hour\": \"09:00:00\"\n" +
                "    },\n" +
                "    \"flightNumber\": 1,\n" +
                "    \"price\": 1628.0\n" +
                "  }";
        Flight flight = OngaBungaAPI.getInstance().GetFlight(jsonFlightTest);
        assertNotNull(flight);
        assertEquals(1, flight.getFlightNumber());
        assertEquals("Salé", flight.getDepartureInfo().getAirport().getCity().getName());
        assertEquals("Économie", flight.getCabine().getType());
        System.out.println(flight.getFlightNumber());
        System.out.println(flight.getCabine().getType());
    }
    @Test
    void TestIfCollectionCreatedFromJsonSuccessfully(){
        String jsonFlightTest = "[{\"arrivalInfo\":{\"airport\":{\"city\":{\"name\":\"Paris\",\"pays\":{\"name\":\"France\"}},\"name\":\" Paris-Charles de Gaulle\"},\"date\":\"2021-02-28\",\"hour\":\"11:45:00\"},\"available\":true,\"cabine\":{\"availablePlaces\":0,\"capacity\":343,\"type\":\"Économie\"},\"departureInfo\":{\"airport\":{\"city\":{\"name\":\"Salé\",\"pays\":{\"name\":\"Maroc\"}},\"name\":\" Aéroport Rabat-Salé\"},\"date\":\"2021-02-28\",\"hour\":\"09:00:00\"},\"flightNumber\":1,\"price\":1628.0},{\"arrivalInfo\":{\"airport\":{\"city\":{\"name\":\"Bruxelles\",\"pays\":{\"name\":\"Belgique\"}},\"name\":\"Aéroport de Bruxelles\"},\"date\":\"2021-03-02\",\"hour\":\"20:20:00\"},\"available\":false,\"cabine\":{\"availablePlaces\":0,\"capacity\":88,\"type\":\"Éco-premium\"},\"departureInfo\":{\"airport\":{\"city\":{\"name\":\"Casablanca\",\"pays\":{\"name\":\"Maroc\"}},\"name\":\"Aéroport de Casablanca Mohammed V\"},\"date\":\"2021-03-02\",\"hour\":\"17:00:00\"},\"flightNumber\":2,\"price\":2930.0},{\"arrivalInfo\":{\"airport\":{\"city\":{\"name\":\"Rome\",\"pays\":{\"name\":\"Italie\"}},\"name\":\"Aéroport Léonard-de-Vinci de Rome Fiumicino\"},\"date\":\"2021-03-02\",\"hour\":\"07:25:00\"},\"available\":false,\"cabine\":{\"availablePlaces\":0,\"capacity\":9,\"type\":\"Première\"},\"departureInfo\":{\"airport\":{\"city\":{\"name\":\"Marrakech\",\"pays\":{\"name\":\"Maroc\"}},\"name\":\"Aéroport de Marrakech-Ménara\"},\"date\":\"2021-03-02\",\"hour\":\"06:10:00\"},\"flightNumber\":3,\"price\":2971.0},{\"arrivalInfo\":{\"airport\":{\"city\":{\"name\":\"Paris\",\"pays\":{\"name\":\"France\"}},\"name\":\" Paris-Charles de Gaulle\"},\"date\":\"2021-02-02\",\"hour\":\"17:12:00\"},\"available\":false,\"cabine\":{\"availablePlaces\":0,\"capacity\":80,\"type\":\"Affaire\"},\"departureInfo\":{\"airport\":{\"city\":{\"name\":\"Salé\",\"pays\":{\"name\":\"Maroc\"}},\"name\":\" Aéroport Rabat-Salé\"},\"date\":\"2021-03-02\",\"hour\":\"15:00:00\"},\"flightNumber\":4,\"price\":2736.0},{\"arrivalInfo\":{\"airport\":{\"city\":{\"name\":\"Lyon\",\"pays\":{\"name\":\"France\"}},\"name\":\"Aéroport de Lyon-Saint Exupéry\"},\"date\":\"2021-03-17\",\"hour\":\"16:36:00\"},\"available\":false,\"cabine\":{\"availablePlaces\":0,\"capacity\":88,\"type\":\"Éco-premium\"},\"departureInfo\":{\"airport\":{\"city\":{\"name\":\"Fès\",\"pays\":{\"name\":\"Maroc\"}},\"name\":\"Aéroport Fès Saïss\"},\"date\":\"2021-03-17\",\"hour\":\"14:00:00\"},\"flightNumber\":5,\"price\":1543.0},{\"arrivalInfo\":{\"airport\":{\"city\":{\"name\":\"Paris\",\"pays\":{\"name\":\"France\"}},\"name\":\" Paris-Charles de Gaulle\"},\"date\":\"2021-02-24\",\"hour\":\"11:45:00\"},\"available\":true,\"cabine\":{\"availablePlaces\":0,\"capacity\":343,\"type\":\"Économie\"},\"departureInfo\":{\"airport\":{\"city\":{\"name\":\"Salé\",\"pays\":{\"name\":\"Maroc\"}},\"name\":\" Aéroport Rabat-Salé\"},\"date\":\"2021-02-28\",\"hour\":\"09:00:00\"},\"flightNumber\":8,\"price\":1628.0},{\"arrivalInfo\":{\"airport\":{\"city\":{\"name\":\"Paris\",\"pays\":{\"name\":\"France\"}},\"name\":\" Paris-Charles de Gaulle\"},\"date\":\"2021-02-24\",\"hour\":\"11:45:00\"},\"available\":true,\"cabine\":{\"availablePlaces\":0,\"capacity\":343,\"type\":\"Économie\"},\"departureInfo\":{\"airport\":{\"city\":{\"name\":\"Salé\",\"pays\":{\"name\":\"Maroc\"}},\"name\":\" Aéroport Rabat-Salé\"},\"date\":\"2021-02-28\",\"hour\":\"09:00:00\"},\"flightNumber\":9,\"price\":1628.0},{\"arrivalInfo\":{\"airport\":{\"city\":{\"name\":\"Paris\",\"pays\":{\"name\":\"France\"}},\"name\":\" Paris-Charles de Gaulle\"},\"date\":\"2021-02-24\",\"hour\":\"11:45:00\"},\"available\":true,\"cabine\":{\"availablePlaces\":0,\"capacity\":343,\"type\":\"Économie\"},\"departureInfo\":{\"airport\":{\"city\":{\"name\":\"Salé\",\"pays\":{\"name\":\"Maroc\"}},\"name\":\" Aéroport Rabat-Salé\"},\"date\":\"2021-02-28\",\"hour\":\"09:00:00\"},\"flightNumber\":10,\"price\":1628.0},{\"arrivalInfo\":{\"airport\":{\"city\":{\"name\":\"Paris\",\"pays\":{\"name\":\"France\"}},\"name\":\" Paris-Charles de Gaulle\"},\"date\":\"2021-02-24\",\"hour\":\"11:45:00\"},\"available\":true,\"cabine\":{\"availablePlaces\":0,\"capacity\":343,\"type\":\"Économie\"},\"departureInfo\":{\"airport\":{\"city\":{\"name\":\"Salé\",\"pays\":{\"name\":\"Maroc\"}},\"name\":\" Aéroport Rabat-Salé\"},\"date\":\"2021-02-28\",\"hour\":\"09:00:00\"},\"flightNumber\":11,\"price\":1628.0},{\"arrivalInfo\":{\"airport\":{\"city\":{\"name\":\"Paris\",\"pays\":{\"name\":\"France\"}},\"name\":\" Paris-Charles de Gaulle\"},\"date\":\"2021-02-24\",\"hour\":\"11:45:00\"},\"available\":true,\"cabine\":{\"availablePlaces\":0,\"capacity\":343,\"type\":\"Économie\"},\"departureInfo\":{\"airport\":{\"city\":{\"name\":\"Salé\",\"pays\":{\"name\":\"Maroc\"}},\"name\":\" Aéroport Rabat-Salé\"},\"date\":\"2021-02-28\",\"hour\":\"09:00:00\"},\"flightNumber\":12,\"price\":1628.0},{\"arrivalInfo\":{\"airport\":{\"city\":{\"name\":\"Paris\",\"pays\":{\"name\":\"France\"}},\"name\":\" Paris-Charles de Gaulle\"},\"date\":\"2021-02-24\",\"hour\":\"11:45:00\"},\"available\":true,\"cabine\":{\"availablePlaces\":0,\"capacity\":343,\"type\":\"Économie\"},\"departureInfo\":{\"airport\":{\"city\":{\"name\":\"Salé\",\"pays\":{\"name\":\"Maroc\"}},\"name\":\" Aéroport Rabat-Salé\"},\"date\":\"2021-02-28\",\"hour\":\"09:00:00\"},\"flightNumber\":13,\"price\":1628.0},{\"arrivalInfo\":{\"airport\":{\"city\":{\"name\":\"Paris\",\"pays\":{\"name\":\"France\"}},\"name\":\" Paris-Charles de Gaulle\"},\"date\":\"2021-02-24\",\"hour\":\"11:45:00\"},\"available\":true,\"cabine\":{\"availablePlaces\":0,\"capacity\":343,\"type\":\"Économie\"},\"departureInfo\":{\"airport\":{\"city\":{\"name\":\"Salé\",\"pays\":{\"name\":\"Maroc\"}},\"name\":\" Aéroport Rabat-Salé\"},\"date\":\"2021-02-28\",\"hour\":\"09:00:00\"},\"flightNumber\":14,\"price\":1628.0}]";
        ArrayList<Flight> flights = OngaBungaAPI.getInstance().GetFlightsFromJsonArray(jsonFlightTest);
        assertNotNull(flights);
        System.out.println(flights.size());
        Flight flight = flights.get(0);
        assertNotNull(flight);
        System.out.println("flight.flightNumber : " + flight.getFlightNumber());
    }
}