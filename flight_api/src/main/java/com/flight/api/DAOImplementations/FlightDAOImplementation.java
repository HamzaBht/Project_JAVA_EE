package com.flight.api.DAOImplementations;

import com.flight.api.DAO.DAOException;
import com.flight.api.DAO.IDAO;
import com.flight.api.flight_api.Airport;
import com.flight.api.flight_api.Cabine;
import com.flight.api.flight_api.DepartureArrivalInfo;
import com.flight.api.flight_api.Flight;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class FlightDAOImplementation implements IDAO<Flight> {
    private final DAOFactory instance = DAOFactory.getInstance();

    private void SetStringPrep(Flight flight, PreparedStatement prep) throws DAOException{
        try {
            prep.setDate(1, (Date) flight.getDepartureInfo().getDate());
            prep.setDate(2, (Date) flight.getArrivalInfo().getDate());
            prep.setTime(3,flight.getDepartureInfo().getHour());
            prep.setTime(4,flight.getArrivalInfo().getHour());
            prep.setDouble(5,flight.getPrice());
            prep.setInt(6, Integer.parseInt(String.valueOf(flight.getDepartureInfo().getAirport().getID())));
            prep.setInt(7, Integer.parseInt(String.valueOf(flight.getArrivalInfo().getAirport().getID())));
            prep.setInt(8,flight.getCabine().getID());
            prep.setBoolean(9,flight.isAvailable());
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public int Create(Flight flight) throws DAOException {
        try {
            String sql= "insert into vol (datedepart,datearrivee,heuredepart,heurearrivee,price" +
                    ",aeroport_idaeroportdepart,aeroport_idaeroportarrivee,cabine_idcabine,isreservationavailable) " +
                    "values(?,?,?,?,?,?,?,?,?,0)";
            PreparedStatement prep= instance.getConnection().prepareStatement(sql);
            SetStringPrep(flight,prep);
            return prep.executeUpdate();
        }
        catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public Flight Find(int id) throws DAOException {
        try{
            String sql="select * from vol where idvol=?  limit 1";
            PreparedStatement prep=instance.getConnection().prepareStatement(sql);
            prep.setString(1,String.valueOf(id));
            ResultSet res=prep.executeQuery();
            Flight flight = null;
            if(res.next()){
                flight = map(res);
            }
            return flight;
        }
        catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    private Flight map(ResultSet res) throws SQLException {
        Flight flight;
        Date date = res.getDate(2);
        Time time = res.getTime(4);
        int airportID = res.getInt(7);
        Airport airport = DAOFactory.getInstance().getAirportDAO().Find(airportID);
        DepartureArrivalInfo departure = new DepartureArrivalInfo(date,time,airport);

        date = res.getDate(3);
        time = res.getTime(5);
        airportID = res.getInt(8);
        airport = DAOFactory.getInstance().getAirportDAO().Find(airportID);
        DepartureArrivalInfo arrival = new DepartureArrivalInfo(date, time, airport);
        int cabineID = res.getInt(9);
        Cabine cabine = DAOFactory.getInstance().getCabineDAO().Find(cabineID);
        Double price = res.getDouble(6);

        flight = new Flight(res.getInt(1), cabine,departure,arrival,price);
        flight.setAvailable(res.getBoolean(10));

        return flight;
    }

    @Override
    public boolean Update(Flight flight) throws DAOException {
        try{
            String sql="update flight set dateDepart=? and dateArrivee=? and heureDepart=? and heureArrivee=?" +
                    "and idAeroportDepart=? and idAeroportArrivee=? and price=? and idCabine=? " +
                    "and isReservationAvailable=? where idvol=?";
            PreparedStatement prep=instance.getConnection().prepareStatement(sql);
            SetStringPrep(flight,prep);
            prep.setString(10,String.valueOf(flight.getFlightNumber()));
            try {
                prep.executeUpdate();
            }catch (Exception e){
                return false;
            }
            return true;
        }
        catch (SQLException e){
            throw new DAOException(e);
        }
    }

    @Override
    public boolean Remove(int id) throws DAOException {
        try {
            PreparedStatement prep = instance.getConnection().prepareStatement("delete from flight where idvol=?");
            prep.setString(1, String.valueOf(id));
            try {
                prep.executeUpdate();
            } catch (Exception e) {
                return false;
            }
            return true;
        }
        catch (SQLException e){
            throw new DAOException(e);
        }
    }

    @Override
    public Collection<Flight> findAll() throws DAOException {
        try{
            ArrayList<Flight> flights = new ArrayList<>();
            String sql="select * from vol";
            PreparedStatement prep=instance.getConnection().prepareStatement(sql);
            ResultSet res=prep.executeQuery();
            while (res.next()){
                Flight flight = map(res);
                flights.add(flight);
            }
            return flights;
        }
        catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
