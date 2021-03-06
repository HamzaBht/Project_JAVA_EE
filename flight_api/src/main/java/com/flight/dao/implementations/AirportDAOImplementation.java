package com.flight.dao.implementations;

import com.flight.dao.DAOException;
import com.flight.dao.IDAO;
import com.flight.api.beans.Airport;
import com.flight.api.beans.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class AirportDAOImplementation implements IDAO<Airport> {
    private final DAOFactory instance = DAOFactory.getInstance();

    private void SetStringPrep(Airport airport, PreparedStatement prep) throws DAOException{
        try {
            prep.setString(1,airport.getName());
            prep.setString(2,String.valueOf(airport.getCity().getID()));
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    private static Airport map(ResultSet res) throws SQLException{
        int airportID = res.getInt(1);
        String airportName = res.getString(2);
        int cityID = res.getInt(3);
        City city = DAOFactory.getInstance().getCityDAO().Find(cityID);
        Airport airport = new Airport(airportName, city);
        airport.setID(airportID);
        return airport;
    }
    @Override
    public int Create(Airport airport) throws DAOException {
        Connection connection = null;
        PreparedStatement prep;
        try {
            String sql="insert into aeroport(nom,ville_idville) values(?,?) ";
            connection = instance.getConnection();
            prep= connection.prepareStatement(sql);
            SetStringPrep(airport,prep);
            int status = prep.executeUpdate();
            connection.close();
            return status;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throw new DAOException(throwables);
                }
            }
        }
    }

    @Override
    public Airport Find(int id) throws DAOException {
        Connection connection = null;
        try{
            String sql="select * from aeroport where idaeroport=?  limit 1";
            connection = instance.getConnection();
            PreparedStatement prep= connection.prepareStatement(sql);
            prep.setString(1,String.valueOf(id));
            ResultSet res=prep.executeQuery();
            Airport airport=null;
            if(res.next()){
                airport = map(res);
            }
            connection.close();
            return airport;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throw new DAOException(throwables);
                }
            }
        }
    }

    @Override
    public boolean Update(Airport airport) throws DAOException {
        Connection connection = null;
        try {
            connection = instance.getConnection();
            String sql="update aeroport set nom=? and ville_idVille=? where idaeroport=?";
            PreparedStatement prep = connection.prepareStatement(sql);
            SetStringPrep(airport,prep);
            prep.setString(3,String.valueOf(airport.getID()));
            prep.executeUpdate();
            connection.close();
            return true;
        }
        catch (SQLException e) {
            throw new DAOException(e);
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throw new DAOException(throwables);
                }
            }
        }
    }

    @Override
    public boolean Remove(int id) throws DAOException {
        PreparedStatement prep;
        Connection connection = null;
        try{
            connection = instance.getConnection();
            prep=connection.prepareStatement("delete from aeroport where idaeroport=?");
            prep.setString(1, String.valueOf(id));
            prep.executeUpdate();
            connection.close();
            return true;
        }
        catch (SQLException e) {
            throw new DAOException(e);
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throw new DAOException(throwables);
                }
            }
        }
    }

    @Override
    public Collection<Airport> findAll() throws DAOException {
        return null;
    }
}
