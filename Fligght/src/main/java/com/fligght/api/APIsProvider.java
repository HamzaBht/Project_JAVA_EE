package com.fligght.api;

import com.fligght.api.implementations.KamehamehaAPI;
import com.fligght.api.implementations.OngaBungaAPI;

import java.util.ArrayList;

public class APIsProvider {
    ArrayList<IFlightAPI> flightAPIs;
    static APIsProvider instance;
    private APIsProvider(){
        flightAPIs = new ArrayList<>();
        OngaBungaAPI ongaBungaAPI = OngaBungaAPI.getInstance();
        KamehamehaAPI kamehamehaAPI = KamehamehaAPI.getInstance();
        flightAPIs.add(kamehamehaAPI);
        flightAPIs.add(ongaBungaAPI);
    }

    public static APIsProvider getInstance() {
        if (instance == null){
            instance = new APIsProvider();
        }
        return instance;
    }

    public ArrayList<IFlightAPI> getFlightAPIs() {
        return flightAPIs;
    }
}
