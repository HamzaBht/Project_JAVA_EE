package com.flight.dao.implementations;


import com.flight.dao.DAOException;
import com.flight.dao.IDAO;
import com.flight.api.beans.City;
import com.flight.api.beans.Pays;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class CityDAOImplementation implements IDAO<City> {
    private final DAOFactory instance = DAOFactory.getInstance();
    private void SetStringPrep(City city, PreparedStatement prep) throws DAOException{
        try {
            prep.setString(1,city.getName());
            prep.setInt(2,city.getPays().getID());
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    @Override
    public int Create(City city) throws DAOException {
        try{
            String sql="insert into ville (nom,pays_idpays) values(?,?) ";
            PreparedStatement prep= instance.getConnection().prepareStatement(sql);
            SetStringPrep(city,prep);
            return prep.executeUpdate();
        }
        catch (SQLException e){
            throw new DAOException(e);
        }
    }

    @Override
    public City Find(int id) throws DAOException {
        try{
            String sql="select * from ville where idville=?  limit 1";
            PreparedStatement prep=instance.getConnection().prepareStatement(sql);
            prep.setString(1,String.valueOf(id));
            ResultSet res=prep.executeQuery();
            City city=null;
            if(res.next()){
                city = map(res);
            }
            return city;
        }
        catch (SQLException e){
            throw new DAOException(e);
        }
    }

    private City map(ResultSet res) throws SQLException {
        City city = new City();
        city.setName(res.getString(1));
        city.setID(res.getInt(2));

        int paysID = res.getInt(3);
        Pays pays = DAOFactory.getInstance().getPaysDAO().Find(paysID);
        city.setPays(pays);

        return city;
    }

    @Override
    public boolean Update(City city) throws DAOException {
        try{
            String sql="update ville set nom=? and pays_idpays=? where idville=?";
            PreparedStatement prep=instance.getConnection().prepareStatement(sql);
            SetStringPrep(city,prep);
            prep.setString(3,String.valueOf(city.getID()));
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
        try{
            PreparedStatement prep=instance.getConnection().prepareStatement("delete from ville where idville=?");
            prep.setString(1, String.valueOf(id));
            try{
                prep.executeUpdate();
            }catch (Exception e){
                return  false;
            }
            return true;
        }
        catch (SQLException e){
            throw new DAOException(e);
        }
    }

    @Override
    public Collection<City> findAll() throws DAOException {
        return null;
    }
}
