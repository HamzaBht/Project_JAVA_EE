package com.fligght.api.implementations;

import com.fligght.api.IFlightAPI;
import com.fligght.beans.*;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.adapter.JsonbAdapter;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static com.fligght.beans.CabineClass.*;

public class KamehamehaAPI implements IFlightAPI {
    private final String URI = "http://localhost:8080/api/v2/vols";
    private final String Name = "Kamehameha";
    private final String URL = "";
    //TODO: change the icon
    private final String iconLocation = "ressource/images/RAM.png";
    static KamehamehaAPI instance;
    Client client;

    private KamehamehaAPI() {
        client = ClientBuilder.newClient();
    }

    public static KamehamehaAPI getInstance() {
        if (instance == null) {
            instance = new KamehamehaAPI();
        }
        return instance;
    }
    public String SearchQueryToJson(SearchQuery query)
    {
        JsonbConfig config = new JsonbConfig().withAdapters(new KamehamehaAPI.QueryAdapter());
        Jsonb jsonb = JsonbBuilder.create(config);
        return jsonb.toJson(query);
    }

    @Override
    public ArrayList<Flight> GetFlights(SearchQuery query) {
        String queryJson = SearchQueryToJson(query);
        String respond = GetJsonFromAPI(queryJson);
        return GetFlightsFromJsonArray(respond);
    }

    public String GetJsonFromAPI(String queryJson) {
        String respond = client.target(URI).request(MediaType.APPLICATION_JSON).post(Entity.entity(queryJson,MediaType.APPLICATION_JSON_TYPE), String.class);
        return respond;
    }

    public Flight GetFlight(String jsonText) {
        JsonbConfig config = new JsonbConfig().withAdapters(new KamehamehaAPI.FlightAdapter());
        Jsonb jsonb = JsonbBuilder.create(config);
        Flight flight = jsonb.fromJson(jsonText, Flight.class);
        return flight;
    }

    public ArrayList<Flight> GetFlightsFromJsonArray(String jsonText) {
        JsonbConfig config = new JsonbConfig().withAdapters(new KamehamehaAPI.FlightAdapter());
        Jsonb jsonb = JsonbBuilder.create(config);
        ArrayList<Flight> flights = jsonb.fromJson(jsonText, new ArrayList<Flight>() {
        }.getClass().getGenericSuperclass());
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

    @Override
    public Boolean isFilterable() {
        return true;
    }

    public class QueryAdapter implements JsonbAdapter<SearchQuery, JsonObject>{
        @Override
        public JsonObject adaptToJson(SearchQuery query) throws Exception {
            String cabinetClass = "";
            if (query.getCabineClass() != null) {
                switch (query.getCabineClass()) {
                    case FirstClass:
                        cabinetClass = "Première";
                        break;
                    case BusinessClass:
                        cabinetClass = "Affaire";
                        break;
                    case PremiumEconomy:
                        cabinetClass = "Éco-premium";
                        break;
                    case Economy:
                        cabinetClass = "Économie";
                        break;
                    default:
                        cabinetClass = "";
                }
            }
            String dateDepart;
            String dateArrivee;
            String aeroportArriveName;
            String aeroportDepartName;
            try{
                dateDepart = query.getDeparture().getDate().toString();
            }
            catch (Exception e)
            {
                dateDepart = "";
            }
            try{
                dateArrivee = query.getArrival().getDate().toString();
            }
            catch (Exception e)
            {
                dateArrivee = "";
            }
            try{
                aeroportArriveName = query.getArrival().getCity().getName();
            }
            catch (Exception e)
            {
                aeroportArriveName = "";
            }
            try{
                aeroportDepartName = query.getDeparture().getCity().getName();
            }
            catch (Exception e)
            {
                aeroportDepartName = "";
            }
            return Json.createObjectBuilder()
                    .add("dateDepart", dateDepart)
                    .add("dateArrivee",dateArrivee)
                    .add("aeroportArriveName", aeroportArriveName)
                    .add("aeroportDepartName", aeroportDepartName)
                    .add("cabineType", cabinetClass)
                    .build();
        }

        @Override
        public SearchQuery adaptFromJson(JsonObject jsonObject) throws Exception {
            return null;
        }
    }

    //re adapt the json to match our beans, because the APIs don't necessary follow the same format
    public class FlightAdapter implements JsonbAdapter<Flight, JsonObject> {
        @Override
        public JsonObject adaptToJson(Flight flight) throws Exception {
            return null;
        }

        @Override
        public Flight adaptFromJson(JsonObject jsonObject) throws Exception {
            Flight flight = new Flight();
            flight.setFlightNumber(0);
            flight.setPrice(jsonObject.getJsonNumber("price").doubleValue());
            flight.setAvailable(true);
            DepartureArrivalInfo departureInfo = new DepartureArrivalInfo();
            DepartureArrivalInfo arrivalInfo = new DepartureArrivalInfo();
            Cabine cabine = new Cabine();
            flight.setArrivalInfo(arrivalInfo);
            flight.setDepartureInfo(departureInfo);
            flight.setCabine(cabine);
            //departure infos
            Airport departAirport = new Airport();
            departureInfo.setDate(LocalDate.parse(jsonObject.getString("dateDepart")));
            departureInfo.setHour(LocalTime.parse(jsonObject.getString("heureDepart")));
            departureInfo.setAirport(departAirport);
            City departCity = new City();
            Pays departPays = new Pays();
            departAirport.setName(jsonObject.getString("aeroportDepartName"));
            departAirport.setCity(departCity);
            departCity.setPays(departPays);
            departCity.setName("");
            //arrival infos
            Airport arrivalAirport = new Airport();
            arrivalInfo.setDate(LocalDate.parse(jsonObject.getString("dateArrivee")));
            arrivalInfo.setHour(LocalTime.parse(jsonObject.getString("heureArrivee")));
            arrivalInfo.setAirport(arrivalAirport);
            City arrivalCity = new City();
            Pays arrivalPays = new Pays();
            arrivalAirport.setName(jsonObject.getString("aeroportArriveName"));
            arrivalAirport.setCity(arrivalCity);
            arrivalCity.setPays(arrivalPays);
            arrivalCity.setName("");
            //cabinet
            String cabineType = jsonObject.getString("cabineType");
            CabineClass ourCabineType;
            switch (cabineType){
                case "Première" : ourCabineType = FirstClass; break;
                case "Affaire" : ourCabineType = BusinessClass; break;
                case "Éco-premium" : ourCabineType = PremiumEconomy; break;
                case "Économie" : ourCabineType = Economy; break;
                default: ourCabineType = OTHER;
            }
            cabine.setType(ourCabineType);
            //just magical value
            cabine.setAvailablePlaces(100);
            cabine.setCapacity(100);
            return flight;
        }
    }
}
