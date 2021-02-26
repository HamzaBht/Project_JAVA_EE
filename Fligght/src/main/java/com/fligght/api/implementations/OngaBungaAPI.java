package com.fligght.api.implementations;

import com.fligght.api.IFlightAPI;
import com.fligght.beans.*;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.adapter.JsonbAdapter;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;

public class OngaBungaAPI implements IFlightAPI {
    private final String URI = "http://localhost:8080/api/flights";
    private final String Name = "OngaBunga";
    private final String URL = "";
    private final String iconLocation = "ressource/images/RAM.png";
    static OngaBungaAPI instance;
    Client client;

    public OngaBungaAPI(){
        client = ClientBuilder.newClient();
    }
    public static OngaBungaAPI getInstance(){
        if (instance == null) {
            instance = new OngaBungaAPI();
        }
        return instance;
    }


    @Override
    public ArrayList<Flight> GetFlights() {
        String respond = GetJsonFromAPI();
        ArrayList<Flight> flights = GetFlightsFromJsonArray(respond);
        return flights;
    }
    public String GetJsonFromAPI(){
        String respond = client.target(URI).request(MediaType.APPLICATION_JSON).get(String.class);
        return respond;
    }
    public Flight GetFlight(String jsonText){
        JsonbConfig config = new JsonbConfig().withAdapters(new FlightAdapter());
        Jsonb jsonb = JsonbBuilder.create(config);
        Flight flight = jsonb.fromJson(jsonText,Flight.class);
        return flight;
    }

    public ArrayList<Flight> GetFlightsFromJsonArray(String jsonText){
        //jsonText = "[{\"arrivalInfo\":{\"airport\":{\"city\":{\"name\":\"Paris\",\"pays\":{\"name\":\"France\"}},\"name\":\" Paris-Charles de Gaulle\"},\"date\":\"2021-02-28\",\"hour\":\"11:45:00\"},\"available\":true,\"cabine\":{\"availablePlaces\":0,\"capacity\":343,\"type\":\"Économie\"},\"departureInfo\":{\"airport\":{\"city\":{\"name\":\"Salé\",\"pays\":{\"name\":\"Maroc\"}},\"name\":\" Aéroport Rabat-Salé\"},\"date\":\"2021-02-28\",\"hour\":\"09:00:00\"},\"flightNumber\":1,\"price\":1628.0},{\"arrivalInfo\":{\"airport\":{\"city\":{\"name\":\"Bruxelles\",\"pays\":{\"name\":\"Belgique\"}},\"name\":\"Aéroport de Bruxelles\"},\"date\":\"2021-03-02\",\"hour\":\"20:20:00\"},\"available\":false,\"cabine\":{\"availablePlaces\":0,\"capacity\":88,\"type\":\"Éco-premium\"},\"departureInfo\":{\"airport\":{\"city\":{\"name\":\"Casablanca\",\"pays\":{\"name\":\"Maroc\"}},\"name\":\"Aéroport de Casablanca Mohammed V\"},\"date\":\"2021-03-02\",\"hour\":\"17:00:00\"},\"flightNumber\":2,\"price\":2930.0},{\"arrivalInfo\":{\"airport\":{\"city\":{\"name\":\"Rome\",\"pays\":{\"name\":\"Italie\"}},\"name\":\"Aéroport Léonard-de-Vinci de Rome Fiumicino\"},\"date\":\"2021-03-02\",\"hour\":\"07:25:00\"},\"available\":false,\"cabine\":{\"availablePlaces\":0,\"capacity\":9,\"type\":\"Première\"},\"departureInfo\":{\"airport\":{\"city\":{\"name\":\"Marrakech\",\"pays\":{\"name\":\"Maroc\"}},\"name\":\"Aéroport de Marrakech-Ménara\"},\"date\":\"2021-03-02\",\"hour\":\"06:10:00\"},\"flightNumber\":3,\"price\":2971.0},{\"arrivalInfo\":{\"airport\":{\"city\":{\"name\":\"Paris\",\"pays\":{\"name\":\"France\"}},\"name\":\" Paris-Charles de Gaulle\"},\"date\":\"2021-02-02\",\"hour\":\"17:12:00\"},\"available\":false,\"cabine\":{\"availablePlaces\":0,\"capacity\":80,\"type\":\"Affaire\"},\"departureInfo\":{\"airport\":{\"city\":{\"name\":\"Salé\",\"pays\":{\"name\":\"Maroc\"}},\"name\":\" Aéroport Rabat-Salé\"},\"date\":\"2021-03-02\",\"hour\":\"15:00:00\"},\"flightNumber\":4,\"price\":2736.0},{\"arrivalInfo\":{\"airport\":{\"city\":{\"name\":\"Lyon\",\"pays\":{\"name\":\"France\"}},\"name\":\"Aéroport de Lyon-Saint Exupéry\"},\"date\":\"2021-03-17\",\"hour\":\"16:36:00\"},\"available\":false,\"cabine\":{\"availablePlaces\":0,\"capacity\":88,\"type\":\"Éco-premium\"},\"departureInfo\":{\"airport\":{\"city\":{\"name\":\"Fès\",\"pays\":{\"name\":\"Maroc\"}},\"name\":\"Aéroport Fès Saïss\"},\"date\":\"2021-03-17\",\"hour\":\"14:00:00\"},\"flightNumber\":5,\"price\":1543.0},{\"arrivalInfo\":{\"airport\":{\"city\":{\"name\":\"Paris\",\"pays\":{\"name\":\"France\"}},\"name\":\" Paris-Charles de Gaulle\"},\"date\":\"2021-02-24\",\"hour\":\"11:45:00\"},\"available\":true,\"cabine\":{\"availablePlaces\":0,\"capacity\":343,\"type\":\"Économie\"},\"departureInfo\":{\"airport\":{\"city\":{\"name\":\"Salé\",\"pays\":{\"name\":\"Maroc\"}},\"name\":\" Aéroport Rabat-Salé\"},\"date\":\"2021-02-28\",\"hour\":\"09:00:00\"},\"flightNumber\":8,\"price\":1628.0},{\"arrivalInfo\":{\"airport\":{\"city\":{\"name\":\"Paris\",\"pays\":{\"name\":\"France\"}},\"name\":\" Paris-Charles de Gaulle\"},\"date\":\"2021-02-24\",\"hour\":\"11:45:00\"},\"available\":true,\"cabine\":{\"availablePlaces\":0,\"capacity\":343,\"type\":\"Économie\"},\"departureInfo\":{\"airport\":{\"city\":{\"name\":\"Salé\",\"pays\":{\"name\":\"Maroc\"}},\"name\":\" Aéroport Rabat-Salé\"},\"date\":\"2021-02-28\",\"hour\":\"09:00:00\"},\"flightNumber\":9,\"price\":1628.0},{\"arrivalInfo\":{\"airport\":{\"city\":{\"name\":\"Paris\",\"pays\":{\"name\":\"France\"}},\"name\":\" Paris-Charles de Gaulle\"},\"date\":\"2021-02-24\",\"hour\":\"11:45:00\"},\"available\":true,\"cabine\":{\"availablePlaces\":0,\"capacity\":343,\"type\":\"Économie\"},\"departureInfo\":{\"airport\":{\"city\":{\"name\":\"Salé\",\"pays\":{\"name\":\"Maroc\"}},\"name\":\" Aéroport Rabat-Salé\"},\"date\":\"2021-02-28\",\"hour\":\"09:00:00\"},\"flightNumber\":10,\"price\":1628.0},{\"arrivalInfo\":{\"airport\":{\"city\":{\"name\":\"Paris\",\"pays\":{\"name\":\"France\"}},\"name\":\" Paris-Charles de Gaulle\"},\"date\":\"2021-02-24\",\"hour\":\"11:45:00\"},\"available\":true,\"cabine\":{\"availablePlaces\":0,\"capacity\":343,\"type\":\"Économie\"},\"departureInfo\":{\"airport\":{\"city\":{\"name\":\"Salé\",\"pays\":{\"name\":\"Maroc\"}},\"name\":\" Aéroport Rabat-Salé\"},\"date\":\"2021-02-28\",\"hour\":\"09:00:00\"},\"flightNumber\":11,\"price\":1628.0},{\"arrivalInfo\":{\"airport\":{\"city\":{\"name\":\"Paris\",\"pays\":{\"name\":\"France\"}},\"name\":\" Paris-Charles de Gaulle\"},\"date\":\"2021-02-24\",\"hour\":\"11:45:00\"},\"available\":true,\"cabine\":{\"availablePlaces\":0,\"capacity\":343,\"type\":\"Économie\"},\"departureInfo\":{\"airport\":{\"city\":{\"name\":\"Salé\",\"pays\":{\"name\":\"Maroc\"}},\"name\":\" Aéroport Rabat-Salé\"},\"date\":\"2021-02-28\",\"hour\":\"09:00:00\"},\"flightNumber\":12,\"price\":1628.0},{\"arrivalInfo\":{\"airport\":{\"city\":{\"name\":\"Paris\",\"pays\":{\"name\":\"France\"}},\"name\":\" Paris-Charles de Gaulle\"},\"date\":\"2021-02-24\",\"hour\":\"11:45:00\"},\"available\":true,\"cabine\":{\"availablePlaces\":0,\"capacity\":343,\"type\":\"Économie\"},\"departureInfo\":{\"airport\":{\"city\":{\"name\":\"Salé\",\"pays\":{\"name\":\"Maroc\"}},\"name\":\" Aéroport Rabat-Salé\"},\"date\":\"2021-02-28\",\"hour\":\"09:00:00\"},\"flightNumber\":13,\"price\":1628.0},{\"arrivalInfo\":{\"airport\":{\"city\":{\"name\":\"Paris\",\"pays\":{\"name\":\"France\"}},\"name\":\" Paris-Charles de Gaulle\"},\"date\":\"2021-02-24\",\"hour\":\"11:45:00\"},\"available\":true,\"cabine\":{\"availablePlaces\":0,\"capacity\":343,\"type\":\"Économie\"},\"departureInfo\":{\"airport\":{\"city\":{\"name\":\"Salé\",\"pays\":{\"name\":\"Maroc\"}},\"name\":\" Aéroport Rabat-Salé\"},\"date\":\"2021-02-28\",\"hour\":\"09:00:00\"},\"flightNumber\":14,\"price\":1628.0}]";
        JsonbConfig config = new JsonbConfig().withAdapters(new FlightAdapter());
        Jsonb jsonb = JsonbBuilder.create(config);
        ArrayList<Flight> flights = jsonb.fromJson(jsonText, new ArrayList<Flight>(){}.getClass().getGenericSuperclass());
        return flights;
    }
    @Override
    public String getName() {
        return Name;
    }

    @Override
    public String getURL() {
        return URL;
    }

    @Override
    public String getIconLocation() {
        return iconLocation;
    }

    //re adapt the json to match our beans, because the APIs don't necessary follow the same format
    public class FlightAdapter implements JsonbAdapter<Flight, JsonObject>{

        @Override
        public JsonObject adaptToJson(Flight flight) throws Exception {
            return null;
        }

        @Override
        public Flight adaptFromJson(JsonObject jsonObject) throws Exception {
            Flight flight = new Flight();
            flight.setFlightNumber(jsonObject.getInt("flightNumber"));
            flight.setPrice(jsonObject.getJsonNumber("price").doubleValue());
            flight.setAvailable(jsonObject.getBoolean("available"));
            JsonbConfig config = new JsonbConfig().withAdapters(new DepartureArrivalInfoAdapter(), new CabineAdapter());
            Jsonb jsonb = JsonbBuilder.create(config);
            Cabine cabine = jsonb.fromJson(jsonObject.getJsonObject("cabine").toString(),Cabine.class);
            DepartureArrivalInfo departure = jsonb.fromJson(jsonObject.getJsonObject("departureInfo").toString(),DepartureArrivalInfo.class);
            DepartureArrivalInfo arrival   = jsonb.fromJson(jsonObject.getJsonObject("arrivalInfo").toString(),DepartureArrivalInfo.class);
            flight.setCabine(cabine);
            flight.setArrivalInfo(arrival);
            flight.setDepartureInfo(departure);
            return flight;
        }
    }
    public class DepartureArrivalInfoAdapter implements JsonbAdapter<DepartureArrivalInfo,JsonObject>{

        @Override
        public JsonObject adaptToJson(DepartureArrivalInfo departureArrivalInfo) throws Exception {
            return null;
        }

        @Override
        public DepartureArrivalInfo adaptFromJson(JsonObject jsonObject) throws Exception {
            DepartureArrivalInfo info = new DepartureArrivalInfo();
            LocalDate date;
            LocalTime hour;
            date = LocalDate.parse(jsonObject.getString("date"));
            hour = LocalTime.parse(jsonObject.getString("hour"));
            JsonbConfig config = new JsonbConfig().withAdapters(new AirportAdapter());
            Airport airport = JsonbBuilder.create(config).fromJson(jsonObject.getJsonObject("airport").toString(),Airport.class);
            info.setAirport(airport);
            info.setDate(date);
            info.setHour(hour);
            return info;
        }
    }
    public class AirportAdapter implements JsonbAdapter<Airport,JsonObject>{
        @Override
        public JsonObject adaptToJson(Airport airport) throws Exception {
            return null;
        }
        @Override
        public Airport adaptFromJson(JsonObject jsonObject) throws Exception {
            Airport airport = new Airport();
            airport.setName(jsonObject.getString("name"));
            JsonbConfig config = new JsonbConfig().withAdapters(new CityAdapter());
            City city = JsonbBuilder.create(config).fromJson(jsonObject.getJsonObject("city").toString(),City.class);
            airport.setCity(city);
            return airport;
        }
    }
    public class CabineAdapter implements JsonbAdapter<Cabine,JsonObject>{

        @Override
        public JsonObject adaptToJson(Cabine cabine) throws Exception {
            return null;
        }
        @Override
        public Cabine adaptFromJson(JsonObject jsonObject) throws Exception {
            Cabine cabine = new Cabine();
            cabine.setType(jsonObject.getString("type"));
            cabine.setCapacity(jsonObject.getInt("capacity"));
            cabine.setAvailablePlaces(jsonObject.getInt("availablePlaces"));
            return cabine;
        }
    }
    public class PaysAdapter implements JsonbAdapter<Pays, JsonObject>{
        @Override
        public JsonObject adaptToJson(Pays pays) throws Exception {
            return null;
        }

        @Override
        public Pays adaptFromJson(JsonObject jsonObject) throws Exception {
            Pays pays = new Pays();
            pays.setName(jsonObject.getString("name"));
            return pays;
        }
    }
    public class CityAdapter implements JsonbAdapter<City, JsonObject>{

        @Override
        public JsonObject adaptToJson(City city) throws Exception {
            return null;
        }

        @Override
        public City adaptFromJson(JsonObject jsonObject) throws Exception {
            City city = new City();
            city.setName(jsonObject.getString("name"));
            JsonbConfig config = new JsonbConfig().withAdapters(new PaysAdapter());
            Pays pays = JsonbBuilder.create(config).fromJson(jsonObject.getJsonObject("pays").toString(),Pays.class);
            city.setPays(pays);
            return city;
        }
    }
}
